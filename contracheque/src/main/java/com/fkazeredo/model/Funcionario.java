package com.fkazeredo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class Funcionario implements Serializable {

    private static final long serialVersionUID = 1582411914473751764L;

    private Long id;

    private String nome;

    private String sobrenome;

    private String cargo;

    private BigDecimal salarioBruto;

    public Funcionario() {
    }

    public Funcionario(Long id, String nome, String sobrenome, String cargo,  BigDecimal salarioBruto) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cargo = cargo;
        this.salarioBruto = salarioBruto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public BigDecimal getSalarioBruto() {
        return salarioBruto;
    }

    public void setSalarioBruto(BigDecimal salarioBruto) {
        this.salarioBruto = salarioBruto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Funcionario that = (Funcionario) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", cargo='" + cargo + '\'' +
                ", salarioBruto=" + salarioBruto +
                '}';
    }
}