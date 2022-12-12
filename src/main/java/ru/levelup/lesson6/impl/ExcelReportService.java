package ru.levelup.lesson6.impl;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.levelup.lesson6.ReportService;

@Service
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
