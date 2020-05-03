package br.com.pipa.score.service.setup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"br.com.pipa.score.api.*"})
public class ScorePointsControlApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScorePointsControlApplication.class, args);
    }
}
