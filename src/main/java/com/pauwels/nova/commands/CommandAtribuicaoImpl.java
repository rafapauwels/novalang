package com.pauwels.nova.commands;

public class CommandAtribuicaoImpl implements Command {
    private final String id;
    private final String expr;

    public CommandAtribuicaoImpl(String id, String expr) {
        this.id = id;
        this.expr = expr;
    }

    @Override
    public String generate() {
        return id + " = " + expr + ";";
    }
}
