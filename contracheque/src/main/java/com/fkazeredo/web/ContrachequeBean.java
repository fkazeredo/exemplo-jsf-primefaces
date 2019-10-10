package com.fkazeredo.web;

import com.fkazeredo.model.Contracheque;
import com.fkazeredo.service.ContrachequeService;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class ContrachequeBean implements Serializable {

    private static final long serialVersionUID = -4341815624449491032L;

    @Inject
    private ContrachequeService contrachequeService;

    private Contracheque contracheque;

    private Long id;

    public void calcular(){
        contracheque = contrachequeService.obterContracheque(id);
    }

    public Contracheque getContracheque() {
        return contracheque;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
