package model;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Periodo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String ano;
    private int semestre;

    private Date inicio;
    private Date fim;

    @Column(columnDefinition = "TINYINT(1)")
	private boolean ativo;

    public Periodo() {}

    public Periodo(String ano, int semestre, Date inicio, Date fim) {
        this.ano = ano;
        this.semestre = semestre;
        this.inicio = inicio;
        this.fim = fim;
    }

	public int getSemestre() {
		return semestre;
	}
	
	public Date getInicio() {
        return inicio;
    }
	
	public Date getFim() {
		return fim;
	}
	
	public String getAno() {
		return ano;
	}

	public int getId() {
		return id;
	}
	
	public void setInicio(Date inicio) {
		this.inicio = inicio;
		ano = inicio.toString().substring(0, 4);
	}
	
	public void setFim(Date fim) {
		this.fim = fim;
	}
	
	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}
	public void iniciarPeriodo() {
		this.ativo = true;
	}
	
	public void consolidarPeriodo() {
		this.ativo = false;
	}
	
}
