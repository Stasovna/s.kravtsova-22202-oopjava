package Tests;

import commands.Pop;
import session.CalculationSession;
import exceptions.NEmptyStackException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PopTest {
    private final Pop pop = new Pop();
    private CalculationSession context;

    @Before
    public void newContext() {
        context = new CalculationSession();
    }

    @Test(expected = NEmptyStackException.class)
    public void testEmptyStack() throws NEmptyStackException {
        pop.execute(context, null);
    }

    @Test
    public void testCorrect() throws NEmptyStackException {
        context.push(1234.56);
        context.push(123.4567);
        pop.execute(context, null);
        Assert.assertEquals(1234.56, context.peek(), 1e-5D);
    }
}