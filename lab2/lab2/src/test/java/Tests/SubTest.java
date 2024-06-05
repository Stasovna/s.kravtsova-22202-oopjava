package Tests;

import commands.Sub;
import session.CalculationSession;
import exceptions.NEmptyStackException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SubTest {
    private final Sub subTest = new Sub();
    private CalculationSession context;

    @Before
    public void newContext() {
        context = new CalculationSession();
    }

    @Test(expected = NEmptyStackException.class)
    public void testEmptyStack() throws NEmptyStackException {
        subTest.execute(context, null);
    }

    @Test
    public void testValid() throws NEmptyStackException {
        context.push(1234.5678);
        context.push(987.65432);
        subTest.execute(context, null);
        Assert.assertEquals(246.91348, context.peek(), 1e-5D);
    }
}