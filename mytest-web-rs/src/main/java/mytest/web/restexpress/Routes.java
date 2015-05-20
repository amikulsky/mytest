package mytest.web.restexpress;

import io.netty.handler.codec.http.HttpMethod;

import org.restexpress.RestExpress;

public abstract class Routes {
    public static void define(Configuration config, RestExpress server) {
        server.uri("/records/{sortOrder}.{format}", config.getSampleController()).action("getAll", HttpMethod.GET).name(Constants.Routes.RECORDS_LIST);
        server.uri("/records", config.getSampleController()).action("post", HttpMethod.POST).name(Constants.Routes.RECORDS_POST);
    }
}
