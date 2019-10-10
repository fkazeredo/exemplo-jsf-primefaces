package com.fkazeredo.web;

import com.fkazeredo.model.Funcionario;
import com.fkazeredo.service.FuncionarioService;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class ContrachequeBean implements Serializable {

    private static final long serialVersionUID = -4341815624449491032L;
    @Inject
    private FuncionarioService funcionarioService;

    private Funcionario funcionario;

    public void calcular(){
        System.out.println("Calculando...");
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }
}
