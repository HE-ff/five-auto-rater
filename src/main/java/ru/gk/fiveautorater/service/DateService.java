package ru.gk.fiveautorater.service;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.annotation.PostConstruct;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class DateService {

    private DateFile dateFile;
    private final ObjectMapper objectMapper;
    private final Resource resourceFile;
    private static final Logger log = LoggerFactory.getLogger(DateService.class);
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private final LocalDate startDate;


    @Autowired
    public DateService(@Value("${startDate}") final String startDate, @Value("file:${dateFile}") final Resource resourceFile, final ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
        this.resourceFile = resourceFile;
        if (StringUtils.hasLength(startDate)) {
            this.startDate = LocalDate.parse(startDate.trim(), DATE_FORMAT);
        } else {
            this.startDate = null;
        }

    }

    @PostConstruct
    private void readOrCreateDateFile() throws IOException {

        if (resourceFile.exists()) {
            dateFile = this.objectMapper.readValue(resourceFile.getFile(), DateFile.class);
        } else {
            dateFile = new DateFile(startDate != null ? startDate : LocalDate.now().minusDays(31));
            objectMapper.writeValue(new File(resourceFile.getFilename()), dateFile);
        }
    }

    public LocalDate getDate() {
        return dateFile.lastDate;
    }

    public void updateDate(LocalDate date) {

        try {
            dateFile.lastDate = date;
            objectMapper.writeValue(new File(resourceFile.getFilename()), dateFile);
            log.info("Last date: " + date.format(DATE_FORMAT));
        } catch (IOException e) {
            log.error("updateDate:", e);
        }

    }

    private static class DateFile {
        @JsonProperty(required = true)
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
        private LocalDate lastDate;

        @JsonCreator
        public DateFile(@JsonProperty(value = "lastDate", required = true) LocalDate lastDate) {
            this.lastDate = lastDate;
        }
    }
}
