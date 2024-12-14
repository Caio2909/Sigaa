package dao;

import model.*;

import javax.persistence.*;
import java.util.List;

public class AlunoDAO {
    private EntityManager em;

    public AlunoDAO(EntityManager em) {
        this.em = em;
    }

    public void salvar(Aluno aluno) {
        em.getTransaction().begin();
        em.persist(aluno);
        em.getTransaction().commit();
    }

    public Aluno buscarPorId(int id) {
        return em.find(Aluno.class, id);
    }
    public Aluno buscarPorNomeESenha(String nome, String senha) {
        try {
            return em.createQuery("FROM Aluno WHERE nome = :nome AND senha = :senha", Aluno.class)
                     .setParameter("nome", nome)
                     .setParameter("senha", senha)
                     .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    public List<Aluno> listarTodos() {
        return em.createQuery("FROM Aluno", Aluno.class).getResultList();
    }

    public void atualizar(Aluno aluno) {
        em.getTransaction().begin();
        em.merge(aluno);
        em.getTransaction().commit();
    }

    public void deletar(int id) {
        Aluno aluno = buscarPorId(id);
        if (aluno != null) {
            em.getTransaction().begin();
            em.remove(aluno);
            em.getTransaction().commit();
        }
    }
}
