/**
 * 
 */
package mytest.web;

import java.util.LinkedList;
import java.util.List;

import mytest.api.Record;

/**
 * Store list of records
 * @author mikulsky
 */
public class PersistenceFactory {
    /** List of records */
    private static List<Record> RECORDS = new LinkedList<Record>();

    /** @return list of stored records */
    public static synchronized List<Record> getRecords() {
        return RECORDS;
    }

    /**
     * add record to store
     * @param record {@link Record} to store
     */
    public static synchronized void addRecord(Record record) {
        RECORDS.add(record);
    }
}
