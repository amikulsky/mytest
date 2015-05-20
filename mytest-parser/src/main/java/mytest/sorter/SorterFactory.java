/**
 * 
 */
package mytest.sorter;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import mytest.api.Record;

/**
 * @author mikulsky
 */
public class SorterFactory {

    public static void sort(List<Record> records, SortType sort) {
        switch (sort) {
            case GENDER_ASC:
                Collections.sort(records, new Comparator<Record>() {
                    /* (non-Javadoc)
                     * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
                     */
                    public int compare(Record o1, Record o2) {
                        if (o1.getGender() == null && o2.getGender() != null)
                            return 1;
                        if (o1.getGender() != null && o2.getGender() == null)
                            return -1;
                        return o1.getGender().compareTo(o2.getGender());
                    }
                });
                break;
            case BIRTH_ASC:
                Collections.sort(records, new Comparator<Record>() {
                    /* (non-Javadoc)
                     * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
                     */
                    public int compare(Record o1, Record o2) {
                        if (o1.getDateOfBirth() == null && o2.getDateOfBirth() != null)
                            return 1;
                        if (o1.getDateOfBirth() != null && o2.getDateOfBirth() == null)
                            return -1;
                        return o1.getDateOfBirth().compareTo(o2.getDateOfBirth());
                    }
                });
                break;
            case LASTNNAME_DESC:
                Collections.sort(records, new Comparator<Record>() {
                    /* (non-Javadoc)
                     * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
                     */
                    public int compare(Record o1, Record o2) {
                        if (o1.getLastName() == null && o2.getLastName() != null)
                            return 1;
                        if (o1.getLastName() != null && o2.getLastName() == null)
                            return -1;
                        return o2.getLastName().compareTo(o1.getLastName());
                    }
                });
                break;
            case FIRSTLASTNAME_ASC:
                Collections.sort(records, new Comparator<Record>() {
                    /* (non-Javadoc)
                     * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
                     */
                    public int compare(Record o1, Record o2) {
                        if (o1.getFirstName() == null && o2.getFirstName() != null)
                            return 1;
                        if (o1.getFirstName() != null && o2.getFirstName() == null)
                            return -1;
                        return ("" + o1.getFirstName() + o1.getLastName()).compareTo("" + o2.getFirstName() + o2.getLastName());
                    }
                });
                break;
        }
    }
}
