package ru.levelup.lesson6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ConditionalReportRunner {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ConditionalReportRunner.class, args);
        ReportService reportService = context.getBean(ReportService.class);
        System.out.println(reportService.generate());
    }
}
