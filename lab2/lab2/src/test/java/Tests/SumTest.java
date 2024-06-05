package Tests;

import commands.Sum;
import session.CalculationSession;
import exceptions.NEmptyStackException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SumTest {
    private final Sum sumTest = new Sum();
    private CalculationSession context;

    @Before
    public void newContext() {
        context = new CalculationSession();
    }

    @Test(expected = NEmptyStackException.class)
    public void testEmptyStack() throws NEmptyStackException {
        sumTest.execute(context, null);
    }

    @Test
    public void testPositive() throws NEmptyStackException {
        context.push(1234.56);
        context.push(9.87);
        sumTest.execute(context, null);
        Assert.assertEquals(1244.43, context.peek(), 1e-5D);
    }

    @Test
    public void testNegative() throws NEmptyStackException {
        context.push(-9.87);
        context.push(-1.23);
        sumTest.execute(context, null);
        Assert.assertEquals(-11.1, context.peek(), 1e-5D);
    }

    @Test
    public void testPosAndNeg() throws NEmptyStackException {
        context.push(-123.4);
        context.push(98.765);
        sumTest.execute(context, null);
        Assert.assertEquals(-24.635, context.peek(), 1e-5D);
    }
}