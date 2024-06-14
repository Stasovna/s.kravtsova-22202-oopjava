package Tests;

import commands.Div;
import session.CalculationSession;
import exceptions.MathException;
import exceptions.NEmptyStackException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DivTest {
    private final Div divTest = new Div();
    private CalculationSession context;

    @Before
    public void newContext() {
        context = new CalculationSession();
    }

    @Test(expected = NEmptyStackException.class)
    public void testEmptyStack() throws NEmptyStackException, MathException {
        divTest.execute(context, null);
    }

    @Test(expected = MathException.class)
    public void testDivByZero() throws NEmptyStackException, MathException {
        context.push(0.);
        context.push(100.);
        divTest.execute(context, null);
    }

    @Test
    public void testCorrect() throws MathException, NEmptyStackException {
        context.push(2.1);
        context.push(4.2);
        divTest.execute(context, null);
        Assert.assertEquals(2, context.peek(), 1e-5D);
    }
}