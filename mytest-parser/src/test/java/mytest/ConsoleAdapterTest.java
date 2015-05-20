/**
 * 
 */
package mytest;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import junit.framework.TestCase;
import mytest.api.Record;
import mytest.api.exception.MyTestException;
import mytest.sorter.SortType;

import org.junit.Test;

/**
 * @author mikulsky
 */
public class ConsoleAdapterTest {
    private final static String FILE1 = "/testPipe.txt";
    private final static String FILE2 = "/testComma.txt";
    private final static String FILE3 = "/testSpace.txt";

    @Test
    public void testReadFile() throws MyTestException {
        String file = ConsoleAdapterTest.class.getResource(FILE1).getFile();
        List<Record> records = new ConsoleAdapter().readFile(file);
        TestCase.assertTrue("Records must not be empty", records.size() > 0);
    }

    @Test
    public void testMain() throws IOException, ParseException, MyTestException {
        String file1 = ConsoleAdapterTest.class.getResource(FILE1).getFile();
        String file2 = ConsoleAdapterTest.class.getResource(FILE2).getFile();
        String file3 = ConsoleAdapterTest.class.getResource(FILE3).getFile();
        ConsoleAdapter.main(file1, file2, file3, SortType.BIRTH_ASC.toString());
    }

    @Test
    public void testMainException() {
        try {
            ConsoleAdapter.main();
        } catch (MyTestException e) {
            TestCase.assertTrue(ConsoleAdapter.MSG_PARAMS_ERROR.equals(e.getMessage()));
        }
    }
}
