package com.fkazeredo.service;

import com.fkazeredo.infra.jpa.Transactional;
import com.fkazeredo.model.Funcionario;
import com.fkazeredo.model.Funcionarios;

import javax.inject.Inject;
import java.util.List;

class FuncionarioServiceImpl implements FuncionarioService {

    private static final long serialVersionUID = 9207027300950119315L;

    private Funcionarios funcionarios;

    @Inject
    FuncionarioServiceImpl(Funcionarios funcionarios) {
        this.funcionarios = funcionarios;
    }

    @Override
    public List<Funcionario> buscarTodos() {
        return funcionarios.todos();
    }

    @Transactional
    @Override
    public Funcionario salvar(Funcionario funcionario) {
        return funcionarios.adicionar(funcionario);
    }

}
