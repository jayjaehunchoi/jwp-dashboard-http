package nextstep.jwp.controller;

import org.apache.coyote.support.HttpMethod;
import org.apache.coyote.web.request.HttpRequest;
import org.apache.coyote.web.response.HttpResponse;

public abstract class AbstractController implements Controller {

    @Override
    public void service(final HttpRequest httpRequest, final HttpResponse httpResponse) {
        if (httpRequest.isSameHttpMethod(HttpMethod.GET)) {
            doGet(httpRequest, httpResponse);
            return;
        }
        doPost(httpRequest, httpResponse);
    }

    protected void doGet(final HttpRequest httpRequest, final HttpResponse httpResponse) {
        throw new UnsupportedOperationException();
    }

    protected void doPost(final HttpRequest httpRequest, final HttpResponse httpResponse) {
        throw new UnsupportedOperationException();
    }
}
