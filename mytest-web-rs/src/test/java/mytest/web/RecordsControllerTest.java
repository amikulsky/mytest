/**
 * 
 */
package mytest.web;

import junit.framework.TestCase;
import mytest.sorter.SortType;

import org.junit.Test;

/**
 * @author mikulsky
 */
public class RecordsControllerTest {
    @Test
    public void testGetSort() {
        RecordsController fixture = new RecordsController();
        TestCase.assertEquals("Gender expected", SortType.GENDER_ASC, fixture.getSort("gender"));
        TestCase.assertEquals("Date of Birth expected", SortType.BIRTH_ASC, fixture.getSort("birthdate"));
        TestCase.assertEquals("Name expected", SortType.FIRSTLASTNAME_ASC, fixture.getSort("name"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetSortFail() {
        new RecordsController().getSort("test");
    }
}
