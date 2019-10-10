package com.fkazeredo.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class Desconto {

    protected BigDecimal valorDoDesconto;
    protected Desconto proximo;

    public abstract void calcular(Contracheque contracheque);

    public void calcularCadeiaDeDescontos(Contracheque contracheque){
        calcular(contracheque);
        if (proximo != null)
            proximo.calcularCadeiaDeDescontos(contracheque);
    }

    public void setProximo(Desconto proximo) {
        this.proximo = proximo;
    }

    public BigDecimal getValorDoDesconto() {
        return valorDoDesconto.setScale(2, RoundingMode.HALF_EVEN);
    }

}
