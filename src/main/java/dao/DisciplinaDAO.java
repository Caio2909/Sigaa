package dao;

import model.*;

import javax.persistence.*;
import java.util.List;

public class DisciplinaDAO {
    private EntityManager em;

    public DisciplinaDAO(EntityManager em) {
        this.em = em;
    }

    public void salvar(Disciplina disciplina) {
        em.getTransaction().begin();
        em.persist(disciplina);
        em.getTransaction().commit();
    }

    public Disciplina buscarPorId(int id) {
        return em.find(Disciplina.class, id);
    }

    public List<Disciplina> listarTodos() {
        return em.createQuery("FROM Disciplina", Disciplina.class).getResultList();
    }

    public void atualizar(Disciplina disciplina) {
        em.getTransaction().begin();
        em.merge(disciplina);
        em.getTransaction().commit();
    }

    public void deletar(int id) {
        Disciplina disciplina = buscarPorId(id);
        if (disciplina != null) {
            em.getTransaction().begin();
            em.remove(disciplina);
            em.getTransaction().commit();
        }
    }
}
