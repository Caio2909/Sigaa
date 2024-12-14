package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    
    @ManyToOne
    private Disciplina disciplina;

    @ManyToOne
    private Periodo periodo;

    @OneToMany(mappedBy = "turma", cascade = CascadeType.ALL)
    private List<Matricula> matriculas = new ArrayList<>();
    
    @Column(name = "numero_turma", nullable = false)
    private String numeroTurma;
    
    public void addMatricula(Matricula matricula) {
        this.matriculas.add(matricula);
    }


	public int getCodigo() {
	    return codigo;
	}
	
	public void setCodigo(int codigo) {
	    this.codigo = codigo;
	}
	
	public Disciplina getDisciplina() {
	    return disciplina;
	}
	
	public void setDisciplina(Disciplina disciplina) {
	    this.disciplina = disciplina;
	}
	
	public Periodo getPeriodo() {
	    return periodo;
	}
	
	public void setPeriodo(Periodo periodo) {
	    this.periodo = periodo;
	}
	
	public List<Matricula> getMatriculas() {
	    return matriculas;
	}
	
	public void setMatriculas(List<Matricula> matriculas) {
	    this.matriculas = matriculas;
	}
	
	public String getNumeroTurma() {
	    return numeroTurma;
	}
	
	public void setNumeroTurma(String numeroTurma) {
	    this.numeroTurma = numeroTurma;
	}

		
}
