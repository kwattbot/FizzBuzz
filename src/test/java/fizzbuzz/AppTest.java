package fizzbuzz;

import org.junit.BeforeClass;
import org.junit.Test;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static org.junit.Assert.*;

/**
 * Unit test for Fizz Buzz App.
 */
public class AppTest 
{
    static final String STAGE1_FILE = "stage1.txt";
    static final String STAGE2_FILE = "stage2.txt";
    static String stage1Expected =null;
    static String stage2Expected=null;

    private static String readFile(String fileName)
    {
        InputStream inputStream = App.class.getResourceAsStream(fileName);
        StringBuilder sb = new StringBuilder();
        try (Scanner scanner = new Scanner(inputStream, StandardCharsets.UTF_8.name())) {
            while(scanner.hasNext()) {
                sb.append(scanner.next())
                .append(System.lineSeparator());
            }
        }
        sb.setLength(sb.length()-1);
        return sb.toString();
    }

    @BeforeClass
    public static void setup(){
        stage1Expected = readFile(STAGE1_FILE);
        assertNotNull(stage1Expected);
        stage2Expected = readFile(STAGE2_FILE);
        assertNotNull(stage2Expected);
        assertNotEquals(stage1Expected,stage2Expected);
    }

    /**
     * Unit Test for Fizz Buzz Stage 1
     */
    @Test
    public void stage1Test()
    {
        assertEquals( stage1Expected, App.fizzBuzz(App.Stage.ONE));
    }

    /**
     * Unit Test for Fizz Buzz Stage 2
     */
    @Test
    public void stage2Test()
    {
        assertEquals( stage2Expected, App.fizzBuzz(App.Stage.TWO));
    }

}
