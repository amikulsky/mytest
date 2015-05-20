/**
 * 
 */
package mytest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;

import mytest.api.Record;
import mytest.api.exception.MyTestException;
import mytest.parser.Parser;
import mytest.parser.ParserFactory;
import mytest.sorter.SortType;
import mytest.sorter.SorterFactory;

/**
 * @author mikulsky
 */
public class ConsoleAdapter {
    protected final static String MSG_PARAMS_ERROR = "Exactly 4 parameters are expected";

    public static void main(String... args) throws MyTestException {
        if (args == null || args.length != 4)
            throw new MyTestException(MSG_PARAMS_ERROR);

        ConsoleAdapter consoleAdapter = new ConsoleAdapter();
        List<Record> records = new ConsoleAdapter().readFile(args[0]);
        records.addAll(consoleAdapter.readFile(args[1]));
        records.addAll(consoleAdapter.readFile(args[2]));

        SortType sort = SortType.valueOf(args[3]);
        System.out.println(sort);
        SorterFactory.sort(records, sort);

        for (Record record : records) {
            System.out.println(record);
        }
    }

    protected List<Record> readFile(String fileName) throws MyTestException {
        File file = new File(fileName);
        FileReader fr = null;
        try {
            fr = new FileReader(file);
        } catch (IOException e) {
            throw new MyTestException("Cannot read file " + file.getAbsolutePath(), e);
        }
        BufferedReader br = new BufferedReader(fr);
        LinkedList<Record> list = new LinkedList<Record>();
        try {
            String s = br.readLine();
            if (s == null) {
                throw new RuntimeException("No strings attached");
            }
            Parser parser = ParserFactory.getParser(s);
            while (s != null) {
                try {
                    Record record = parser.parse(s);
                    list.add(record);
                    s = br.readLine();
                } catch (ParseException e) {
                    throw new MyTestException("Cannot parse string [" + s + "]", e);
                }
            }
            return list;
        } catch (IOException e) {
            throw new MyTestException("Cannot read file", e);
        } finally {
            try {
                br.close();
            } catch (Exception e) {
                // don't care
            }
            try {
                fr.close();
            } catch (Exception e) {
                // don't care
            }
        }
    }
}
