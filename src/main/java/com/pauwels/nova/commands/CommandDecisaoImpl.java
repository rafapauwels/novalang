package com.pauwels.nova.commands;

import java.util.ArrayList;
import java.util.Objects;

public class CommandDecisaoImpl implements Command {
    private final String condicional;
    private final ArrayList<Command> seVerdadeiro;
    private final ArrayList<Command> seFalso;

    public CommandDecisaoImpl(String condicional, ArrayList<Command> seVerdadeiro, ArrayList<Command> seFalso) {
        this.condicional = condicional;
        this.seVerdadeiro = seVerdadeiro;
        this.seFalso = Objects.requireNonNullElseGet(seFalso, ArrayList::new);
    }

    @Override
    public String generate() {
        StringBuilder str = new StringBuilder("if (" + condicional + ") {");
        for (Command c : seVerdadeiro)
            str.append(c.generate());
        str.append("}");
        if (!seFalso.isEmpty()) {
            str.append(" else {");
            for (Command c: seFalso)
                str.append(c.generate());
        }

        str.append("}");

        return str.toString();
    }
}
