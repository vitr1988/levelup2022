package ru.levelup.lesson6;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.levelup.lesson6.bean.Printer;
import ru.levelup.lesson6.config.ApplicationConfig;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class ReportRunner {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        ReportWrapper wr = context.getBean(ReportWrapper.class);
        wr.printReports();
        wr.printReports();
        wr.printReports();
        wr.printValues();
        System.out.println("-----");
        ReportWrapper wrapper = context.getBean(ReportWrapper.class);
        wr.printReports();
        wr.printReports();
        wr.printReports();
        wr.printReports();
        System.out.println(wrapper.equals(wr));

        System.out.println("-----");
        Printer printer = context.getBean(Printer.class);
        printer.print("TestPhrase1");
        printer.print("TestPhrase1");
        printer.print("TestPhrase1");

        System.out.println("-----");
        Printer printer2 = context.getBean(Printer.class);
        printer2.print("TestPhrase2");
        printer2.print("TestPhrase2");
        printer2.print("TestPhrase2");
    }
}
