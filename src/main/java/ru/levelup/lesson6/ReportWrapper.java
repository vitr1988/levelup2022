package ru.levelup.lesson6;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.levelup.lesson6.bean.Printer;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
//@Scope("prototype")
public class ReportWrapper {

//    private final List<ReportService> reportServiceList;

//    @Value("${application.values}")
//    private String[] values;

//    @Value("${application.value}")
//    private Integer value;

    @Value("${user.dir}")
    private String userDir;

    private final Map<String, ReportService> reportServiceMap;

    private final Printer printer;

    public ReportWrapper(List<ReportService> reportServiceList, Printer printer) {
        this.reportServiceMap = reportServiceList.stream().collect(Collectors.toMap(ReportService::getCode, Function.identity()));
        this.printer = printer;
    }

    public void printReports() {
        reportServiceMap.values().stream()
                .map(ReportService::generate)
                .forEach(this.printer::print);
    }

    public void printValues() {
//        System.out.println(Arrays.toString(values));
//        System.out.println(value);
        System.out.println(userDir);
    }
}
