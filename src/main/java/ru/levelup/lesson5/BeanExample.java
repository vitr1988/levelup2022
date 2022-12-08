package ru.levelup.lesson5;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.levelup.lesson5.bean.TestBean;
import ru.levelup.lesson5.config.AppConfig;

public class BeanExample {

    private static final String CONTEXT_XML = "/spring-context.xml";

    public static void main(String[] args) {
//        TestBean testBean = new TestBean();
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(CONTEXT_XML);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        TestBean testBean = (TestBean) context.getBean("TestBean");
        TestBean testBean = context.getBean(TestBean.class);
        testBean.printPhrase("testBean");
    }
}
