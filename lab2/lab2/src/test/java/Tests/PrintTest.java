package Tests;

import commands.Print;
import session.CalculationSession;
import exceptions.NEmptyStackException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class PrintTest {
    private final Print print = new Print();
    private CalculationSession context;

    private final ByteArrayOutputStream outCaptor = new ByteArrayOutputStream();
    private final PrintStream sysOut = System.out;

    @Before
    public void setUp() {
        context = new CalculationSession();
        outCaptor.reset();
        System.setOut(new PrintStream(outCaptor));
    }

    @After
    public void restore() {
        System.setOut(sysOut);
    }

    @Test(expected = NEmptyStackException.class)
    public void testEmptyStack() throws NEmptyStackException {
        print.execute(context, null);
    }

    @Test
    public void testCorrect() throws NEmptyStackException {
        context.push(12.34);
        print.execute(context, null);
        Assert.assertEquals("12.34", outCaptor.toString().trim());
    }
}