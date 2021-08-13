package com.pauwels.nova.data;

import com.pauwels.nova.exception.IdNaoUtilizadoException;
import com.pauwels.nova.exception.NovaSemanticException;

import java.util.ArrayList;
import java.util.HashMap;

public class NovaSymbolMap {
    private ArrayList<String> idsUtilizados = new ArrayList<>();
    private final HashMap<String, NovaVariable> tabela;

    public NovaSymbolMap() {
        tabela = new HashMap<>();
    }

    public void insereId(String id, NovaVariable symbol) {
        if (idExiste(id)) {
            throw new NovaSemanticException("Variável " + id + " duplicada");
        } else {
            tabela.put(id, symbol);
        }
    }

    public boolean idExiste(String id) {
        return tabela.get(id) != null;
    }

    public void verificaIdsInutilizados() {
        for (String id : tabela.keySet()) {
            if (!idsUtilizados.contains(id))
                throw new IdNaoUtilizadoException("A variável " + id + " foi declara mas não foi utilizada");
        }
    }

    public void idUtilizado(String id) {
        idsUtilizados.add(id);
    }

    public NovaVariable recuperaSymbol(String id) {
        return tabela.get(id);
    }

    public String generateAll() {
        StringBuilder str = new StringBuilder();
        for (String k : tabela.keySet()) {
            str.append(generate(k));
        }
        return str.toString();
    }

    private String generate(String id) {
        NovaVariable var = recuperaSymbol(id);
        String str;
        if (var.getTipo() == NovaTypeEnum.NUMBER) {
            str = "double ";
        } else {
            str = "String ";
        }

        return str + id + ";";
    }
}
