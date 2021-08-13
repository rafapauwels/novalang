package com.pauwels.nova.commands;

import java.util.ArrayList;

public class CommandRepeticaoImpl implements Command {
    private final String condicional;
    private final ArrayList<Command> commands;

    public CommandRepeticaoImpl(String condicional, ArrayList<Command> commands) {
        this.condicional = condicional;
        this.commands = commands;
    }

    @Override
    public String generate() {
        StringBuilder str = new StringBuilder("while (" + condicional + ") {");

        for (Command c : commands)
            str.append(c.generate());

        str.append("}");

        return str.toString();
    }
}
