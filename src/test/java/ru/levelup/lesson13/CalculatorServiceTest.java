package ru.levelup.lesson13;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@Slf4j
@RunWith(MockitoJUnitRunner.class)
public class CalculatorServiceTest {

    private CalculatorService calculatorService;

    @Mock
    private PrintService printService;


    @BeforeClass
    public static void init() {
        log.info("Запустился тестовый класс");
    }

    @AfterClass
    public static void destroy() {
        log.info("Завершился тестовый класс");
    }

    @Before
    public void start() {
        log.info("Запустился тестовый метод");

//        printService = Mockito.mock(PrintService.class);
//        Mockito.when(printService.printAndGet(Mockito.anyInt())).thenReturn(-1);
        calculatorService = new CalculatorService(printService);
    }

    @After
    public void end() {
        log.info("Завершился тестовый метод");
    }

    @Test
    public void testSummaCalculateWithMocks() {
        Assert.assertEquals(25, calculatorService.summa(10, 15));
        Mockito.verify(printService, Mockito.times(1)).print(Mockito.anyInt());
    }

    @Test
    public void testSummaCalculate() {
        Assert.assertEquals(25, calculatorService.summa(10, 15));
        Assert.assertEquals(-5, calculatorService.summa(10, -15));
        Assert.assertEquals(10, calculatorService.summa(10, 0));
        Assert.assertEquals(15, calculatorService.summa(0, 15));
        Assert.assertEquals(15, calculatorService.summa(0, 15));
    }

    @Test
    public void testMinusCalculate() {
        Assert.assertEquals(-5, calculatorService.minus(10, 15));
        Assert.assertEquals(25, calculatorService.minus(10, -15));
        Assert.assertEquals(10, calculatorService.minus(10, 0));
        Assert.assertEquals(-15, calculatorService.minus(0, 15));
    }

    @Test
    public void testDivideCalculate() {
        Assert.assertEquals(5, calculatorService.divide(10, 2));
        Assert.assertEquals(-8, calculatorService.divide(24, -3));
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideCalculateWithException() {
        Assert.assertEquals(10, calculatorService.divide(10, 0));
    }
}
