/**
 * 
 */
package mytest.api;

import java.util.Date;

import junit.framework.TestCase;
import mytest.api.Record.GENDER;

import org.junit.Test;

/**
 * @author mikulsky
 */
@SuppressWarnings("deprecation")
public class RecordTest {
    private final static Record record1 = new Record() {
        {
            setLastName("LastName");
            setFirstName("FirstName");
            setGender(GENDER.MALE);
            setFavoriteColor("FavoriteColor");
            setDateOfBirth(new Date(115, 4, 15, 0, 0));
        }
    };

    private static class TestRecord extends Record {
        {
            setLastName("LastName");
            setFirstName("FirstName");
            setGender(GENDER.MALE);
            setFavoriteColor("FavoriteColor");
            setDateOfBirth(new Date(115, 4, 15, 0, 0));
        }
    }

    private final static Record record2 = new TestRecord();

    @Test
    public void testEquals1() {
        TestCase.assertEquals("Must be equall", record1, record2);

        Record record = new Record() {
            {
                setLastName("LastName");
                setFirstName("FirstName");
                setGender(GENDER.MALE);
                setFavoriteColor("FavoriteColor");
                setDateOfBirth(new Date(115, 4, 15, 0, 0));
            }
        };
        TestCase.assertEquals("Must be equall", record1, record);
        record.setFavoriteColor(null);
        TestCase.assertNotSame("Must not be equall", record1, record);
        record.setFavoriteColor("SomeFavoriteColor");
        TestCase.assertNotSame("Must not be equall", record1, record);
    }

    @Test
    public void testEquals2() {
        Record record = new Record() {
            {
                setLastName("LastName");
                setFirstName("FirstName");
                setGender(GENDER.MALE);
                setFavoriteColor("FavoriteColor");
                setDateOfBirth(new Date(115, 4, 15, 0, 0));
            }
        };
        TestCase.assertEquals("Must be equall", record1, record);
        record.setDateOfBirth(null);
        TestCase.assertNotSame("Must not be equall", record1, record);
        record.setDateOfBirth(new Date(115, 5, 15, 0, 0));
        TestCase.assertNotSame("Must not be equall", record1, record);
    }

    @Test
    public void testEquals3() {
        Record record = new Record() {
            {
                setLastName("LastName");
                setFirstName("FirstName");
                setGender(GENDER.MALE);
                setFavoriteColor("FavoriteColor");
                setDateOfBirth(new Date(115, 4, 15, 0, 0));
            }
        };
        TestCase.assertEquals("Must be equall", record1, record);
        record.setFirstName(null);
        TestCase.assertNotSame("Must not be equall", record1, record);
    }

    @Test
    public void testEquals4() {
        Record record = new Record() {
            {
                setLastName("LastName");
                setFirstName("FirstName");
                setGender(GENDER.MALE);
                setFavoriteColor("FavoriteColor");
                setDateOfBirth(new Date(115, 4, 15, 0, 0));
            }
        };
        TestCase.assertEquals("Must be equall", record1, record);
        record.setGender(null);
        TestCase.assertNotSame("Must not be equall", record1, record);
        record.setGender(GENDER.FEMALE);
        TestCase.assertNotSame("Must not be equall", record1, record);
    }

    @Test
    public void testEquals5() {
        Record record = new Record() {
            {
                setLastName("LastName");
                setFirstName("FirstName");
                setGender(GENDER.MALE);
                setFavoriteColor("FavoriteColor");
                setDateOfBirth(new Date(115, 4, 15, 0, 0));
            }
        };
        TestCase.assertEquals("Must be equall", record1, record);
        record.setLastName("SomeLastName");
        TestCase.assertNotSame("Must not be equall", record1, record);
    }

}
