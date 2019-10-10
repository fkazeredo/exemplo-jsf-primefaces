package com.fkazeredo.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class IRRF extends Desconto {

    private BigDecimal aliquota;
    private BigDecimal parcelaDedutivel;

    public void calcular(Contracheque contracheque) {

        if (contracheque.getInss() == null)
            throw new IllegalArgumentException("O IRRF só pode ser calculado após o INSS");

        BigDecimal valor = contracheque.getFuncionario().getSalario().subtract(contracheque.getInss().valorDoDesconto);

        if (valor.compareTo(new BigDecimal(1903.98)) <= 0) {
            aliquota = new BigDecimal(0);
            parcelaDedutivel = new BigDecimal(0);
            valorDoDesconto = new BigDecimal(0);
        } else if (
                valor.compareTo(new BigDecimal(1903.99)) <= 0
                        && valor.compareTo(new BigDecimal(2826.65)) >= 0) {
            aliquota = new BigDecimal(0.075);
            parcelaDedutivel = new BigDecimal(142.80);
            aplicarDeducao(valor);

        } else if (
                valor.compareTo(new BigDecimal(2826.66)) <= 0
                        && valor.compareTo(new BigDecimal(3751.05)) >= 0) {
            aliquota = new BigDecimal(0.15);
            parcelaDedutivel = new BigDecimal(354.80);
            aplicarDeducao(valor);

        } else if (
                valor.compareTo(new BigDecimal(3751.06)) <= 0
                        && valor.compareTo(new BigDecimal(4664.68)) >= 0) {
            aliquota = new BigDecimal(0.225);
            parcelaDedutivel = new BigDecimal(636.13);
            aplicarDeducao(valor);

        }  else {
            aliquota =  new BigDecimal(0.275);
            parcelaDedutivel =  new BigDecimal(869.36);
            aplicarDeducao(valor);
        }

        contracheque.setIrrf(this);

    }

    private void aplicarDeducao(BigDecimal valor) {
        valorDoDesconto = valor.multiply(aliquota).subtract(parcelaDedutivel);
    }

    public BigDecimal getAliquota() {
        return aliquota.multiply(new BigDecimal(100)).setScale(2, RoundingMode.HALF_EVEN);
    }

    public BigDecimal getParcelaDedutivel() {
        return parcelaDedutivel.setScale(2, RoundingMode.HALF_EVEN);
    }


}
