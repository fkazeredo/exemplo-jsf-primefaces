package com.fkazeredo.service;

import com.fkazeredo.model.Funcionario;
import com.fkazeredo.model.Funcionarios;
import com.fkazeredo.persistence.Transactional;

import javax.inject.Inject;
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
