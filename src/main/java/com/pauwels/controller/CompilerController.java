package com.pauwels.controller;

import com.pauwels.parser.NovaLangLexer;
import com.pauwels.parser.NovaLangParser;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

@Controller("/compile")
public class CompilerController {
    @Post(produces = MediaType.TEXT_PLAIN)
    public HttpResponse<String> compile(@Body CompileRequest request) {
        PrintStream original = System.err;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream newStream = new PrintStream(baos, true, StandardCharsets.UTF_8);
        System.setErr(newStream);
        try {
            NovaLangLexer lexer = new NovaLangLexer(CharStreams.fromString(request.getFonte()));
            CommonTokenStream tokenStream = new CommonTokenStream(lexer);
            NovaLangParser parser = new NovaLangParser(tokenStream);

            parser.prog();
            if (baos.toString().equals(""))
                return HttpResponse.ok(new CompileResponse(parser.generate()).toJson());
            else
                throw new Exception(baos.toString());
        } catch (Exception e) {
            if (baos.toString().trim().equals(""))
                return HttpResponse.badRequest(new CompileResponse(e.getMessage()).toJson());
            else
                return HttpResponse.badRequest(new CompileResponse(baos.toString()).toJson());
        } finally {
            System.setErr(original);
        }
    }
}
