package com.pauwels;

import io.micronaut.runtime.Micronaut;

public class Application {
    //java -cp .:antlr-4.9.2-complete.jar org.antlr.v4.Tool NovaLang.g4 -package com.pauwels.parser -o ./src/main/java/com/pauwels/parser
    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }
}
