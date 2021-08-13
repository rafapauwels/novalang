package com.pauwels.nova.program;

import com.google.googlejavaformat.java.Formatter;
import com.google.googlejavaformat.java.FormatterException;
import com.google.googlejavaformat.java.JavaFormatterOptions;
import com.pauwels.nova.commands.Command;
import com.pauwels.nova.data.NovaSymbolMap;

import java.util.ArrayList;

public class NovaProgram {
    private NovaSymbolMap symbolMap;
    private ArrayList<Command> commands;

    public NovaProgram() { }

    public void setSymbolMap(NovaSymbolMap symbolMap) {
        this.symbolMap = symbolMap;
    }

    public void setCommands(ArrayList<Command> commands) {
        this.commands = commands;
    }

    public ArrayList<Command> getCommands() {
        return commands;
    }

    public String generate() throws FormatterException {
        String target = "";
        target += "import java.util.Scanner;";
        target += "public class Main {";
        target += "public static void main(String args[]) {";
        target += "Scanner _key = new Scanner(System.in);";

        target += symbolMap.generateAll();

        target += generateAllCommands(commands);

        target += "}}";

        return new Formatter(JavaFormatterOptions.builder()
                                .style(JavaFormatterOptions.Style.AOSP)
                            .build()).formatSource(target);
    }

    private String generateAllCommands(ArrayList<Command> commands) {
        StringBuilder str = new StringBuilder();
        for (Command c : commands) {
            str.append(c.generate());
        }
        return str.toString();
    }
}
