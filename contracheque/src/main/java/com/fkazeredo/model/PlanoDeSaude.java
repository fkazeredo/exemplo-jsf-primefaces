package com.fkazeredo.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class PlanoDeSaude extends Desconto {

    private BigDecimal pagoPelaEmpresa = new BigDecimal(0);

    public void calcular(Contracheque contracheque) {

        LocalDate dataDeNascimento = new Date(contracheque.getFuncionario().getDataNascimento().getTime()).toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        Integer idade = Period.between(dataDeNascimento, LocalDate.now()).getYears();

        if (idade >= 0 && idade <= 18) {
            valorDoDesconto = new BigDecimal(283.69);
        } else if (idade >= 19 && idade <= 23) {
            valorDoDesconto = new BigDecimal(354.62);
        } else if (idade >= 24 && idade <= 28) {
            valorDoDesconto = new BigDecimal(443.27);
        } else if (idade >= 29 && idade <= 33) {
            valorDoDesconto = new BigDecimal(487.60);
        } else if (idade >= 34 && idade <= 38) {
            valorDoDesconto = new BigDecimal(511.98);
        } else if (idade >= 39 && idade <= 43) {
            valorDoDesconto = new BigDecimal(563.18);
        } else if (idade >= 44 && idade <= 48) {
            valorDoDesconto = new BigDecimal(703.98);
        } else if (idade >= 49 && idade <= 53) {
            valorDoDesconto = new BigDecimal(774.37);
        } else if (idade >= 54 && idade <= 58) {
            valorDoDesconto = new BigDecimal(967.97);
        } else {
            valorDoDesconto = new BigDecimal(1693.94);
        }

        calcularValorPagoPelaEmpresa(contracheque);

        contracheque.setPlanoDeSaude(this);

    }

    private void calcularValorPagoPelaEmpresa(Contracheque contracheque) {
        BigDecimal umTercoDoSalario = contracheque.getFuncionario().getSalario().divide(new BigDecimal(3), RoundingMode.HALF_EVEN);
        if (valorDoDesconto.compareTo(umTercoDoSalario) > 0){
            pagoPelaEmpresa = valorDoDesconto.subtract(umTercoDoSalario);
            valorDoDesconto = umTercoDoSalario;
        }
    }

    public BigDecimal getPagoPelaEmpresa() {
        return pagoPelaEmpresa;
    }
}
