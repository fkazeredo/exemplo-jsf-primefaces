package com.fkazeredo.service;

import com.fkazeredo.model.Contracheque;

import java.io.Serializable;

public interface ContrachequeService extends Serializable {

    public Contracheque obterContracheque(Long id);

}
