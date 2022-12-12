package ru.levelup.lesson6.impl;

import org.springframework.stereotype.Service;
import ru.levelup.lesson6.ReportService;

@Service
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
