package org.apache.coyote.web.response;

import org.apache.coyote.support.HttpHeader;
import org.apache.coyote.support.HttpHeaders;
import org.apache.coyote.support.HttpStatus;

public class NoBodyResponse extends Response {

    public NoBodyResponse(final HttpStatus httpStatus, final HttpHeaders headers) {
        super(httpStatus, headers);
    }

    public NoBodyResponse(final String version, final HttpStatus httpStatus,
                          final HttpHeaders headers) {
        super(version, httpStatus, headers);
    }

    @Override
    public String createHttpResponse() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getRequestLine());
        getHttpHeaders().getHeaders()
                .forEach((key, value) -> stringBuilder.append(String.format(HEADER_TEMPLATE, key, value)));
        if (!getCookies().isEmpty()) {
            stringBuilder.append(String.format(HEADER_TEMPLATE, HttpHeader.SET_COOKIE.getValue(), getCookieTemplate()));
        }
        return stringBuilder.toString();
    }
}
