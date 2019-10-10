package com.fkazeredo.persistence;

import com.fkazeredo.model.Funcionario;
import com.fkazeredo.model.Funcionarios;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.LockModeType;
import javax.persistence.TypedQuery;
import java.util.List;

class FuncionarioRepository implements Funcionarios {

    private static final long serialVersionUID = 6298979773474593324L;

    private EntityManager entityManager;

    @Inject
    FuncionarioRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Funcionario> todos() {
        TypedQuery<Funcionario> query = entityManager.createQuery(
                "from Funcionario", Funcionario.class);
        return query.getResultList();
    }

    @Override
    public Funcionario comID(Long id) {
        try {
            return entityManager.find(Funcionario.class, id);
        } catch (EntityNotFoundException ex) {
            return null;
        }
    }

    @Override
    public Funcionario adicionar(Funcionario funcionario) {
        return entityManager.merge(funcionario);
    }

}
