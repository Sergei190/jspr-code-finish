package ru.netology;

import org.glassfish.grizzly.Grizzly;
import org.glassfish.grizzly.http.server.HttpHandler;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.grizzly.http.server.Request;
import org.glassfish.grizzly.http.server.Response;

import java.io.IOException;
import java.util.logging.Logger;

public class Main {
    public static final Logger LOGGER = Grizzly.logger(Main.class);

    public static void main(String[] args) throws IOException, InterruptedException {
        final var server = HttpServer.createSimpleServer("static", 9999);
        server.getServerConfiguration().addHttpHandler(new HttpHandler() {
            @Override
            public void service(Request request, Response response) throws Exception {
                response.getWriter().write("ok");
            }
        }, "/api");

        server.start();
        Runtime.getRuntime().addShutdownHook(new Thread(server::shutdown));
        Thread.currentThread().join();
    }
}
