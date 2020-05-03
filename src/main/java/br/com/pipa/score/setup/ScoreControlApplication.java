package br.com.pipa.score.setup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"br.com.pipa.score.*"})
public class ScoreControlApplication {
    public static void main(String[] args) {
        SpringApplication.run(ScoreControlApplication.class, args);
    }
}
