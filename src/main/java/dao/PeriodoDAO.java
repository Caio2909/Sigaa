package dao;

import model.*;

import javax.persistence.*;
import java.util.List;


public class PeriodoDAO {
    private EntityManager em;

    public PeriodoDAO(EntityManager em) {
        this.em = em;
    }

    public void salvar(Periodo periodo) {
        em.getTransaction().begin();
        em.persist(periodo);
        em.getTransaction().commit();
    }

    public Periodo buscarPorId(int id) {
        return em.find(Periodo.class, id);
    }

    public List<Periodo> listarTodos() {
        return em.createQuery("FROM Periodo", Periodo.class).getResultList();
    }
    public List<Periodo> listarAtivos() {
        return em.createQuery("SELECT p FROM Periodo p WHERE p.ativo = true", Periodo.class)
                 .getResultList();
    }
    public void atualizar(Periodo periodo) {
        em.getTransaction().begin();
        em.merge(periodo);
        em.getTransaction().commit();
    }

    public void deletar(int id) {
        Periodo periodo = buscarPorId(id);
        if (periodo != null) {
            em.getTransaction().begin();
            em.remove(periodo);
            em.getTransaction().commit();
        }
    }
}
