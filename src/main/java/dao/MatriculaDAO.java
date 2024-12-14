package dao;

import model.*;

import javax.persistence.*;
import java.util.List;

public class MatriculaDAO {
    private EntityManager em;

    public MatriculaDAO(EntityManager em) {
        this.em = em;
    }

    public void salvar(Matricula matricula) {
        em.getTransaction().begin();
        em.persist(matricula);
        em.getTransaction().commit();
    }

    public Matricula buscarPorId(int id) {
        return em.find(Matricula.class, id);
    }
    
    public List<Matricula> listarPorTurma(int turmaId) {
        TypedQuery<Matricula> query = em.createQuery("SELECT m FROM Matricula m WHERE m.turma.codigo = :turmaId", Matricula.class);
        query.setParameter("turmaId", turmaId);
        return query.getResultList();
    }

    public List<Matricula> listarTodos() {
        return em.createQuery("FROM Matricula", Matricula.class).getResultList();
    }
    
    public List<Matricula> listarPorAluno(Aluno aluno) {
        String jpql = "SELECT m FROM Matricula m WHERE m.aluno = :aluno";
        return em.createQuery(jpql, Matricula.class)
                 .setParameter("aluno", aluno)
                 .getResultList();
    }

    public void atualizar(Matricula matricula) {
        em.merge(matricula);
    }

    public void deletar(int id) {
        Matricula matricula = buscarPorId(id);
        if (matricula != null) {
            em.getTransaction().begin();
            em.remove(matricula);
            em.getTransaction().commit();
        }
    }
}
