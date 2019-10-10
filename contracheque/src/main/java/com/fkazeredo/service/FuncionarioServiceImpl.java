package com.fkazeredo.service;

import com.fkazeredo.model.Funcionario;
import com.fkazeredo.model.Funcionarios;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

public class FuncionarioServiceImpl implements FuncionarioService {

    private static final long serialVersionUID = 9207027300950119315L;

    @Inject
    private Funcionarios funcionarios;

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
