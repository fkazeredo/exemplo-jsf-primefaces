package com.fkazeredo.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class INSS extends Desconto {

    private BigDecimal aliquota;

    private final BigDecimal TETO = new BigDecimal(5839.45);

    public void calcular(Contracheque contracheque) {

        BigDecimal valor = contracheque.getFuncionario().getSalario();

        if (valor.compareTo(new BigDecimal(1751.81)) <= 0) {

            aliquota = new BigDecimal(0.08);

        } else if (
                valor.compareTo(new BigDecimal(1751.82)) >= 0
                && valor.compareTo(new BigDecimal(2919.72)) <= 0) {

            aliquota = new BigDecimal(0.09);

        } else if (
                valor.compareTo(new BigDecimal(2919.73)) >= 0
                && valor.compareTo(TETO) <= 0) {

            aliquota = new BigDecimal(0.11);

        } else {

            aliquota = new BigDecimal(0.11);
            valor = TETO;

        }

        valorDoDesconto = valor.multiply(aliquota);

        contracheque.setInss(this);

    }

    public BigDecimal getAliquota() {
        return aliquota.multiply(new BigDecimal(100)).setScale(2, RoundingMode.HALF_EVEN);
    }

}
