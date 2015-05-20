/**
 * 
 */
package mytest.parser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import mytest.api.Record;

/**
 * Factory class providing parsing functionality
 * @author mikulsky
 */
public class ParserFactory {
    private final static char PIPE = '|';
    private final static char COMMA = ',';
    private final static char SPACE = ' ';

    private final static String DELIMITER_PIPE = "\\|";
    private final static String DELIMITER_COMMA = ",";
    private final static String DELIMITER_SPACE = " ";

    /**
     * find parser for input string
     * @param s input string
     * @return {@link Parser} instance for provided string
     */
    public static Parser getParser(String s) {
        if (s.indexOf(PIPE) != -1)
            return new LocalParser(DELIMITER_PIPE);
        if (s.indexOf(COMMA) != -1)
            return new LocalParser(DELIMITER_COMMA);
        if (s.indexOf(SPACE) != -1)
            return new LocalParser(DELIMITER_SPACE);
        throw new IllegalArgumentException("No Parser found for this string");
    }

    /** Local implementation of {@link Parser} interface */
    private static class LocalParser implements Parser {
        private final String delimiter;
        private final SimpleDateFormat SDF = new SimpleDateFormat("MM/dd/yyyy");

        private LocalParser(String delimiter) {
            this.delimiter = delimiter;
        }

        /* (non-Javadoc)
         * @see mytest.api.parser.Parser#parse(java.lang.String)
         */
        public Record parse(String source) throws ParseException {
            Scanner scanner = new Scanner(source);
            scanner.useDelimiter(this.delimiter);
            Record record = new Record();
            try {
                String s = null;
                s = scanner.next().trim();
                record.setLastName(s);
                s = scanner.next().trim();
                record.setFirstName(s);
                s = scanner.next().trim();
                record.setGender(Record.GENDER.valueOf(s));
                s = scanner.next().trim();
                record.setFavoriteColor(s);
                s = scanner.next().trim();
                record.setDateOfBirth(SDF.parse(s));
            } finally {
                scanner.close();
            }
            return record;
        }

    }

}
