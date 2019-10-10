package com.fkazeredo.service;

import com.fkazeredo.model.Funcionario;

import java.io.Serializable;
import java.util.List;

public interface FuncionarioService extends Serializable {

    List<Funcionario> buscarTodos();
    Funcionario salvar(Funcionario funcionario);

}
