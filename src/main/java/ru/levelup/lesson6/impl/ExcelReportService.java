package ru.levelup.lesson6.impl;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.levelup.lesson6.ReportService;

@Service
@ConditionalOnProperty(name = "application.report.type", havingValue = "excel")
public class ExcelReportService implements ReportService {

    @Override
    public String generate() {
        return "excel";
    }

    @Override
    public String getCode() {
        return "e";
    }
}
