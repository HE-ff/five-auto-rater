package ru.gk.fiveautorater.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.gk.fiveautorater.model.Check;
import ru.gk.fiveautorater.model.DetailCheck;
import ru.gk.fiveautorater.model.Transactions;

@Service
public class WorkerService {

    private static final Logger log = LoggerFactory.getLogger(WorkerService.class);

    private final RequestService requestService;

    private final DateService dateService;

    public WorkerService(RequestService requestService, DateService dateService) {
        this.requestService = requestService;
        this.dateService = dateService;
    }

    @Scheduled(fixedRate = 3_600_000)
    private void worker() {
        try {

            final LocalDate lastDate = dateService.getDate();
            LocalDate newDate = LocalDate.now();
            long offset = 0;
            List<Transactions> transactionsList = new ArrayList<>();
            while (lastDate.compareTo(newDate) <= 0) {
                final Transactions currTran = requestService.getTransactions(offset);
                transactionsList.add(currTran);
                newDate = currTran.getChecks().stream().map(i -> i.getCreatedAt().toLocalDate()).min(LocalDate::compareTo).orElseThrow();
                offset = offset + 5;
            }

            log.info("get transactions list:" + transactionsList.stream().map(i -> i.getChecks().size()).reduce(Integer::sum).orElse(0));

            LocalDate minDate = lastDate;

            for (Transactions tr : transactionsList) {
                for (Check check : tr.getChecks()) {
                    final DetailCheck detailCheck = requestService.getDetail(check.getId());
                    if (detailCheck.getRateStatus().getCode() == 1) {
                        for (DetailCheck.Product pr : detailCheck.getProducts()) {
                            if (pr.getRate() == null) {
                                requestService.rateProduct(check.getId(), pr.getCode());
                                Thread.sleep(5000);
                            }
                        }
                    }
                    if (minDate.isBefore(check.getCreatedAt().toLocalDate()))
                        minDate = check.getCreatedAt().toLocalDate();
                }
            }

            dateService.updateDate(minDate);

        } catch (Throwable e) {
            log.error("worker error", e);
        }
    }

}
