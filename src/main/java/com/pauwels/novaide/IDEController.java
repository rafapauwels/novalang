package com.pauwels.novaide;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import java.net.URI;
import java.net.URISyntaxException;

@Controller()
public class IDEController {
    @Get("/")
    public HttpResponse index() throws URISyntaxException {
        URI location = new URI("/index.html");
        return HttpResponse.redirect(location);
    }
}
