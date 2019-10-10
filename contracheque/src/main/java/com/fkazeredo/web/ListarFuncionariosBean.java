package com.fkazeredo.web;

import com.fkazeredo.model.Funcionario;
import com.fkazeredo.service.FuncionarioService;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class ListarFuncionariosBean implements Serializable {

    private static final long serialVersionUID = 8389318159111976619L;

    @Inject
    private FuncionarioService funcionarioService;

    private List<Funcionario> funcionarios;

    public void buscarTodos() {
        funcionarios = funcionarioService.buscarTodos();
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }
}
