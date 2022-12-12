package ru.levelup.lesson6.impl;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.levelup.lesson6.ReportService;

@Service
@ConditionalOnProperty(name = "application.report.type", havingValue = "csv", matchIfMissing = true)
public class CsvReportService implements ReportService {

    @Override
    public String generate() {
        return "csv";
    }

    @Override
    public String getCode() {
        return "c";
    }


}
