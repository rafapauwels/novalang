package com.pauwels.nova.commands;

import com.pauwels.nova.data.NovaTypeEnum;
import com.pauwels.nova.data.NovaVariable;

public class CommandLeituraImpl implements Command {
    private final String id;
    private final NovaVariable var;

    public CommandLeituraImpl(String id, NovaVariable var) {
        this.id = id;
        this.var = var;
    }

    @Override
    public String generate() {
        return id + " = _key." +
                    (var.getTipo() == NovaTypeEnum.NUMBER ?
                    "nextDouble()" : "nextLine()") +
                ";";
    }
}
