package Tests;

import commands.Mul;
import session.CalculationSession;
import exceptions.NEmptyStackException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MulTest {
    private final Mul mulTest = new Mul();
    private CalculationSession context;

    @Before
    public void newContext() {
        context = new CalculationSession();
    }

    @Test(expected = NEmptyStackException.class)
    public void testEmptyStack() throws NEmptyStackException {
        mulTest.execute(context, null);
    }

    @Test
    public void testCorrect() throws NEmptyStackException {
        context.push(-12.34);
        context.push(123.4);
        mulTest.execute(context, null);
        Assert.assertEquals(-1522.756, context.peek(), 1e-5D);
    }

}