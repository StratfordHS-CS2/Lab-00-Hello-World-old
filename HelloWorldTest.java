import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * The test class HelloWorldTest.
 *
 * @author  Dave Avis
 * @version 06.22.2018
 */
public class HelloWorldTest
{
    private OutputStream os;
    private PrintStream ps;
    /**
     * Default constructor for test class HelloWorldTest.
     */
    public HelloWorldTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        //Prepare to redirect output
        os = new ByteArrayOutputStream();
        ps = new PrintStream(os);
        System.setOut(ps);
        String ls = System.getProperty("line.separator");
    }
    
    /**
     * Tests the output of the HelloWorld class.
     */
    @Test
    public void outputTest()
    {
        String[] args = null;
        String expectedOutput = "Hello World!";
        HelloWorld.main(args);
        assertEquals("Testing for \"Hello World!\"", expectedOutput, os.toString().trim());
    }
    
    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
        //Restore normal output
        PrintStream originalOut = System.out;
        System.setOut(originalOut);
    }
}
