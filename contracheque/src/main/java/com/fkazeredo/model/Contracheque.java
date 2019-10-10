package com.fkazeredo.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Contracheque {

    private Funcionario funcionario;

    private PlanoDeSaude planoDeSaude;

    private INSS inss;

    private IRRF irrf;

    public Contracheque(Funcionario funcionario) {

        if (funcionario == null)
            throw new IllegalArgumentException("Funcionário não pode ser nulo");

        this.funcionario = funcionario;

        calcularDescontos();
    }

    private void calcularDescontos() {

        Desconto descontoEncadeado = definirOrdemDaCadeiaDeDescontos();
        descontoEncadeado.calcularCadeiaDeDescontos(this);

    }

    private Desconto definirOrdemDaCadeiaDeDescontos() {
        Desconto primeiro = new PlanoDeSaude();
        Desconto segundo = new INSS();
        Desconto terceiro = new IRRF();
        primeiro.setProximo(segundo);
        segundo.setProximo(terceiro);
        return primeiro;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public PlanoDeSaude getPlanoDeSaude() {
        return planoDeSaude;
    }

    public void setPlanoDeSaude(PlanoDeSaude planoDeSaude) {
        this.planoDeSaude = planoDeSaude;
    }

    public INSS getInss() {
        return inss;
    }

    public void setInss(INSS inss) {
        this.inss = inss;
    }

    public IRRF getIrrf() {
        return irrf;
    }

    public void setIrrf(IRRF irrf) {
        this.irrf = irrf;
    }

    public BigDecimal getTotalDeDescontos() {
        return planoDeSaude.valorDoDesconto.add(inss.valorDoDesconto.add(irrf.valorDoDesconto)).setScale(2, RoundingMode.HALF_EVEN);
    }

    public BigDecimal getSalarioLiquido() {
        return funcionario.getSalario().subtract(getTotalDeDescontos()).setScale(2, RoundingMode.HALF_EVEN);
    }

}
