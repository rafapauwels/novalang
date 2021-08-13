package com.pauwels.nova.commands;

public class CommandEscritaImpl implements Command {
    private final String id;

    public CommandEscritaImpl(String id) {
        this.id = id;
    }

    @Override
    public String generate() {
        return "Sytem.out.println(" + id  + ");";
    }
}
