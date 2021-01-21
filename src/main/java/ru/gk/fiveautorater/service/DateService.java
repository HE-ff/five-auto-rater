package ru.gk.fiveautorater.service;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

import javax.annotation.PostConstruct;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public class DateService {

    private DateFile dateFile;
    private final ObjectMapper objectMapper;
    private final Resource resourceFile;
    private static final Logger log = LoggerFactory.getLogger(DateService.class);
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    @Autowired
    public DateService(@Value("file:${datefile}") final Resource resourceFile, final ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
        this.resourceFile = resourceFile;
    }

    @PostConstruct
    private void readOrCreateDateFile() throws IOException {

        if (resourceFile.exists()) {
            dateFile = this.objectMapper.readValue(resourceFile.getFile(), DateFile.class);
        } else {
            dateFile = new DateFile(LocalDate.now().minusDays(31));
            this.objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
            objectMapper.setTimeZone(TimeZone.getTimeZone(ZoneId.systemDefault()));
            objectMapper.writeValue(new File(resourceFile.getFilename()), dateFile);
        }
    }

    public LocalDate getDate() {
        return dateFile.lastDate;
    }

    public void updateDate(LocalDate date) {

        try {
            dateFile.lastDate = date;
            objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
            objectMapper.setTimeZone(TimeZone.getTimeZone(ZoneId.systemDefault()));
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
