package com.pauwels.nova.data;

public class NovaVariable {
    private NovaTypeEnum tipo;
    private Object valor;

    public NovaVariable(NovaTypeEnum tipo, Object valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    public NovaTypeEnum getTipo() {
        return tipo;
    }

    public void setTipo(NovaTypeEnum tipo) {
        this.tipo = tipo;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }
}
