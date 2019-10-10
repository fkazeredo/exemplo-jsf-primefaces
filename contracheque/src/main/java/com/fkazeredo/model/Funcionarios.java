package com.fkazeredo.model;

import com.fkazeredo.model.Funcionario;

import java.io.Serializable;
import java.util.List;

public interface Funcionarios extends Serializable {

    List<Funcionario> todos();
    Funcionario comID(Long id);
    Funcionario adicionar(Funcionario funcionario);

}
