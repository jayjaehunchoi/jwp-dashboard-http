package org.apache.coyote.web;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import nextstep.jwp.controller.Controller;
import nextstep.jwp.controller.DefaultController;
import nextstep.jwp.controller.UserCreateController;
import nextstep.jwp.controller.UserLoginController;
import org.apache.coyote.support.Url;
import org.apache.coyote.web.request.HttpRequest;
import org.apache.coyote.web.response.HttpResponse;

public class RequestMapping {

    private static Map<String, Controller> handlers = new ConcurrentHashMap<>();

    static {
        handlers.put("/", new DefaultController());
        handlers.put("/login", new UserLoginController());
        handlers.put("/register", new UserCreateController());
    }

    public void handle(HttpRequest httpRequest, HttpResponse httpResponse) throws IOException {
        if (handlers.containsKey(httpRequest.getRequestUrl())) {
            Controller controller = handlers.get(httpRequest.getRequestUrl());
            controller.service(httpRequest, httpResponse);
            return;
        }
        httpResponse.forward(Url.createUrl(httpRequest.getRequestUrl()));
    }
}
