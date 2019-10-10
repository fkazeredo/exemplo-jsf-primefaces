package com.fkazeredo.web;

import com.fkazeredo.model.Funcionario;
import com.fkazeredo.service.FuncionarioService;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@javax.faces.view.ViewScoped
public class CadastrarFuncionariosBean implements Serializable {

    private static final long serialVersionUID = -4576023475605029000L;

    @Inject
    private FuncionarioService funcionarioService;

    @Inject
    private Funcionario funcionario;

    public void iniciar() {
        if (funcionario == null)
            funcionario = new Funcionario();
    }

    public void salvar() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            this.funcionarioService.salvar(this.funcionario);

            this.funcionario = new Funcionario();
            context.addMessage(null, new FacesMessage("Funcionário salvo com sucesso!"));
        } catch (Exception e) {
            e.printStackTrace();
            FacesMessage mensagem = new FacesMessage(e.getMessage());
            mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
            context.addMessage(null, mensagem);
        }
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }
}
