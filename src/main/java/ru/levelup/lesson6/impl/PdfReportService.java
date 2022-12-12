package ru.levelup.lesson6.impl;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import ru.levelup.lesson6.ReportService;

@Service
@ConditionalOnProperty(name = "application.report.type", havingValue = "pdf")
public class PdfReportService implements ReportService {
    @Override
    public String generate() {
        return "pdf";
    }

    @Override
    public String getCode() {
        return "p";
    }
}
