package mytest.web;

import io.netty.buffer.ByteBuf;

import java.io.IOException;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import mytest.api.Record;
import mytest.parser.Parser;
import mytest.parser.ParserFactory;
import mytest.sorter.SortType;
import mytest.sorter.SorterFactory;
import mytest.web.restexpress.Constants;

import org.restexpress.Request;
import org.restexpress.Response;

/** default service controller */
public class RecordsController {

    public RecordsController() {
        super();
    }

    /**
     * fins all records sorted according to provided 'sortOrder' parameter
     * @param request service request wrapper
     * @param response response wrapper
     * @return list of sorted records
     */
    public List<Record> getAll(Request request, Response response) {
        List<Record> storedRecords = PersistenceFactory.getRecords();
        List<Record> records = new ArrayList<Record>(storedRecords.size());
        records.addAll(storedRecords);

        String sortOrderParam = request.getHeader(Constants.Url.SORT_ORDER, "name");

        SorterFactory.sort(records, this.getSort(sortOrderParam));
        return records;
    }

    /**
     * find sorting clause for provided parameter
     * @param sortParam sort clause provided by request
     * @throws IllegalArgumentException if provided parameter doesn't is not found
     */
    protected SortType getSort(String sortParam) {
        if ("gender".equals(sortParam))
            return SortType.GENDER_ASC;
        else if ("birthdate".equals(sortParam))
            return SortType.BIRTH_ASC;
        if ("name".equals(sortParam))
            return SortType.FIRSTLASTNAME_ASC;
        throw new IllegalArgumentException("Sorting undefined for " + sortParam);
    }

    public String post(Request request, Response response) throws ParseException, IOException {
        ByteBuf body = request.getBody();
        String param = body.toString(0, body.readableBytes(), Charset.defaultCharset());
        System.out.println(param);
        Parser parser = ParserFactory.getParser(param);
        Record record = parser.parse(param);
        PersistenceFactory.addRecord(record);
        return "OK";
    }
}
