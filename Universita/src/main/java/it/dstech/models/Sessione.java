package it.dstech.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "docente")
public class Sessione {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sessione_id")
    private Integer id;
	
	@Column(name = "docente_sessione")
	private List<Docente> listaDocenti;
	
	@Column(name = "materia_sessione")
	private List<Materia> listaMaterie;
	
	@Column(name = "studente_sessione")
	private List<Studente> listaStudenti;
	
	@Column(name = "esami_sessione")
	private List<Esame> listaEsami;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Docente> getListaDocenti() {
		return listaDocenti;
	}

	public void setListaDocenti(List<Docente> listaDocenti) {
		this.listaDocenti = listaDocenti;
	}

	public List<Materia> getListaMaterie() {
		return listaMaterie;
	}

	public void setListaMaterie(List<Materia> listaMaterie) {
		this.listaMaterie = listaMaterie;
	}

	public List<Studente> getListaStudenti() {
		return listaStudenti;
	}

	public void setListaStudenti(List<Studente> listaStudenti) {
		this.listaStudenti = listaStudenti;
	}

	public List<Esame> getListaEsami() {
		return listaEsami;
	}

	public void setListaEsami(List<Esame> listaEsami) {
		this.listaEsami = listaEsami;
	}
	
	
}
