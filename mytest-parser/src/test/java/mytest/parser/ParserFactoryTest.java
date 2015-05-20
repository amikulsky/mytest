/**
 * 
 */
package mytest.parser;

import java.text.ParseException;
import java.util.Date;

import junit.framework.TestCase;
import mytest.api.Record;

import org.junit.Test;

/**
 * @author mikulsky
 */
public class ParserFactoryTest {
    private final static String STR1 = "LastName | FirstName | MALE | FavoriteColor | 05/15/2015";
    private final static String STR2 = "LastName, FirstName, MALE, FavoriteColor, 05/15/2015";
    private final static String STR3 = "LastName FirstName MALE FavoriteColor 05/15/2015";
    private final static String STR4 = "LastName!FirstName!MALE!FavoriteColor!05/15/2015";

    @SuppressWarnings("deprecation")
    private final static Record record = new Record() {
        {
            setLastName("LastName");
            setFirstName("FirstName");
            setGender(Record.GENDER.MALE);
            setFavoriteColor("FavoriteColor");
            setDateOfBirth(new Date(115, 4, 15, 0, 0));
        }
    };

    @Test
    public void testPipe() throws ParseException {
        Record parsed = ParserFactory.getParser(STR1).parse(STR1);
        TestCase.assertEquals(record, parsed);
    }

    @Test
    public void testComma() throws ParseException {
        Record parsed = ParserFactory.getParser(STR2).parse(STR2);
        TestCase.assertEquals(record, parsed);
    }

    @Test
    public void testSpace() throws ParseException {
        Record parsed = ParserFactory.getParser(STR3).parse(STR3);
        TestCase.assertEquals(record, parsed);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testException() throws ParseException {
        ParserFactory.getParser(STR4).parse(STR4);
    }
}
