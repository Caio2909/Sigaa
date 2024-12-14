package dao;

import model.*;

import javax.persistence.*;
import java.util.List;

public class TurmaDAO {
    private EntityManager em;

    public TurmaDAO(EntityManager em) {
        this.em = em;
    }

    public void salvar(Turma turma) {
        em.getTransaction().begin();
        em.persist(turma);
        em.getTransaction().commit();
    }

    public Turma buscarPorId(int id) {
        return em.find(Turma.class, id);
    }
    public List<Turma> listarTurmasDePeriodosAtivos() {
        String jpql = "SELECT t FROM Turma t WHERE t.periodo.ativo = true";
        return em.createQuery(jpql, Turma.class).getResultList();
    }

    public List<Turma> listarTodos() {
        return em.createQuery("FROM Turma", Turma.class).getResultList();
    }

    public void atualizar(Turma turma) {
        em.getTransaction().begin();
        em.merge(turma);
        em.getTransaction().commit();
    }
    public List<Turma> listarTurmasDisponiveisParaAluno(Aluno aluno) {
        String jpql = """
            SELECT t
            FROM Turma t
            WHERE NOT EXISTS (
                SELECT m
                FROM Matricula m
                WHERE m.aluno = :aluno
                AND (m.turma = t OR m.turma.disciplina = t.disciplina)
                AND (m.resultado = 'Aprovado' OR m.resultado = 'Pendente')
            )
        """;

        return em.createQuery(jpql, Turma.class)
                 .setParameter("aluno", aluno)
                 .getResultList();
    }
    public void deletar(int id) {
        Turma turma = buscarPorId(id);
        if (turma != null) {
            em.getTransaction().begin();
            em.remove(turma);
            em.getTransaction().commit();
        }
    }
}
