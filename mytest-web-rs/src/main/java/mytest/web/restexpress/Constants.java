package mytest.web.restexpress;

public class Constants {
    /**
     * These define the URL parmaeters used in the route definition strings (e.g. '{userId}').
     */
    public class Url {
        public static final String SAMPLE_ID = "sampleId";
        public static final String SORT_ORDER = "sortOrder";
    }

    /**
     * These define the route names used in naming each route definitions. These names are used to retrieve URL patterns within the controllers by name to
     * create links in responses.
     */
    public class Routes {

        public static final String RECORDS_LIST = "mytest.records.list";
        public static final String RECORDS_POST = "mytest.records.post";
    }
}
