package ru.gk.fiveautorater;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FiveAutoRaterApplication {

    public static void main(String[] args) {
            SpringApplication.run(FiveAutoRaterApplication.class, args);
    }

}
