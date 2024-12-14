package model;

import javax.persistence.*;

@Entity
public class Matricula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Aluno aluno;

    @ManyToOne
    private Turma turma;

    private String resultado; 

    public Matricula() {}

    public Matricula(Aluno aluno, Turma turma, String resultado) {
        this.aluno = aluno;
        this.turma = turma;
        this.resultado = resultado;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
}
