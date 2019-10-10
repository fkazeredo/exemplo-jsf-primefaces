package com.fkazeredo.service;

import com.fkazeredo.model.Contracheque;
import com.fkazeredo.model.Funcionario;
import com.fkazeredo.model.Funcionarios;

import javax.inject.Inject;

class ContrachequeServiceImpl implements ContrachequeService {

    private static final long serialVersionUID = 3491576205160946065L;


    private Funcionarios funcionarios;

    @Inject
    ContrachequeServiceImpl(Funcionarios funcionarios) {
        this.funcionarios = funcionarios;
    }

    @Override
    public Contracheque obterContracheque(Long id) {
        Funcionario funcionario = funcionarios.comID(id);
        return new Contracheque(funcionario);
    }
}
