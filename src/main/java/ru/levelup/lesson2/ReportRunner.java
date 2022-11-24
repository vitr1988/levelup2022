package ru.levelup.lesson2;

public class ReportRunner {

    public static void main(String[] args) {
        Report report = new Report();
        Report<String> annualReport = new Report<>(1, "ANNUAL", "Employee Salary",
                new Author("Ivanov Vitalii", 34));
        System.out.println(annualReport);

        Report<ReportType> dailyReport =  new Report<>(1, ReportType.DAILY, "Employee Salary",
                new Author("Ivanov Vitalii", 34));
        System.out.println(dailyReport);

        System.out.println(Book.Fields.isbn);
    }
}
