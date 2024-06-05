package Tests;

import commands.Push;
import session.CalculationSession;
import exceptions.BadInputFormatException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PushTest {
    private final Push push = new Push();
    private CalculationSession context;

    @Before
    public void newContext() {
        context = new CalculationSession();
    }

    @Test
    public void testBadNumOfArgs() {
        String[] args = {};
        Exception e = Assert.assertThrows(BadInputFormatException.class,
                () -> push.execute(context, args));
        String expectedMessage = "PUSH should consist of 1 argument.";
        Assert.assertEquals(expectedMessage, e.getMessage());
    }

    @Test
    public void testUnknownVariable() {
        String[] args = {"a"};
        Exception e = Assert.assertThrows(BadInputFormatException.class,
                () -> push.execute(context, args));
        String expectedMessage = "No value named " + args[0];
        Assert.assertEquals(expectedMessage, e.getMessage());
    }

    @Test
    public void testPushNumber() throws BadInputFormatException {
        String[] args = {"12.34"};
        push.execute(context, args);
        Assert.assertEquals(12.34, context.peek(), 1e-5D);
    }

    @Test
    public void testPushVariable() throws BadInputFormatException {
        context.insertValue("a", 12.34);
        String[] args = {"a"};
        push.execute(context, args);
        Assert.assertEquals(12.34, context.peek(), 1e-5D);
    }
}