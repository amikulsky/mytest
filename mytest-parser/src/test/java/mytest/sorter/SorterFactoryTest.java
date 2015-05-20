/**
 * 
 */
package mytest.sorter;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import junit.framework.TestCase;
import mytest.api.Record;

import org.junit.Test;

/**
 * @author mikulsky
 */
public class SorterFactoryTest {

    @SuppressWarnings("deprecation")
    private final static Record record1 = new Record() {
        {
            setLastName("LastName1");
            setFirstName("FirstName1");
            setGender(Record.GENDER.MALE);
            setFavoriteColor("FavoriteColor1");
            setDateOfBirth(new Date(115, 4, 11, 0, 0));
        }
    };
    @SuppressWarnings("deprecation")
    private final static Record record2 = new Record() {
        {
            setLastName("LastName2");
            setFirstName("FirstName2");
            setGender(Record.GENDER.FEMALE);
            setFavoriteColor("FavoriteColor2");
            setDateOfBirth(new Date(115, 4, 12, 0, 0));
        }
    };
    @SuppressWarnings("deprecation")
    private final static Record record3 = new Record() {
        {
            setLastName("LastName3");
            setFirstName("FirstName3");
            setGender(Record.GENDER.FEMALE);
            setFavoriteColor("FavoriteColor3");
            setDateOfBirth(new Date(115, 4, 13, 0, 0));
        }
    };

    @Test
    public void testEmpty() {
        List<Record> list = Collections.emptyList();
        for (SortType sort : SortType.values()) {
            SorterFactory.sort(list, sort);
        }
    }

    @Test
    public void testSortBIRTH_ASC() {
        List<Record> list = Arrays.asList(record3, record2, record1, new Record() {
            {
                setDateOfBirth(null);
            }
        });
        SorterFactory.sort(list, SortType.BIRTH_ASC);
        TestCase.assertEquals(record1, list.get(0));
        TestCase.assertEquals(record2, list.get(1));
        TestCase.assertEquals(record3, list.get(2));
    }

    @Test
    public void testSortGENDER_ASC() {
        List<Record> list = Arrays.asList(record1, record2, record3, new Record() {
            {
                setGender(null);
            }
        });
        SorterFactory.sort(list, SortType.GENDER_ASC);
        TestCase.assertEquals(record1, list.get(2));
    }

    @Test
    public void testSortLASTNNAME_DESC() {
        List<Record> list = Arrays.asList(record2, record1, record3, new Record() {
            {
                setLastName(null);
            }
        });
        SorterFactory.sort(list, SortType.LASTNNAME_DESC);
        TestCase.assertEquals(record3, list.get(0));
        TestCase.assertEquals(record2, list.get(1));
        TestCase.assertEquals(record1, list.get(2));
    }

    @Test
    public void testSortFIRSTLASTNAME_ASC() {
        List<Record> list = Arrays.asList(record1, record2, record3, new Record() {
            {
                setFirstName(null);
                setLastName(null);
            }
        });
        SorterFactory.sort(list, SortType.FIRSTLASTNAME_ASC);
        TestCase.assertEquals(record1, list.get(0));
        TestCase.assertEquals(record2, list.get(1));
        TestCase.assertEquals(record3, list.get(2));
    }

}
