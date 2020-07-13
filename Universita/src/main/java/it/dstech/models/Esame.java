package it.dstech.models;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
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
@Table(name = "esame")
public class Esame {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "esame_id")
	private Integer id;

	@Column(name = "nome_esame")
	private String nome;

	@Column(name = "data_esame")
	private String data;

	@Column(name = "pass_esame", columnDefinition = "boolean default false")
	private boolean superato;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@Column(name = "docente_id")
	private List<Docente> listaDocente;

	@ManyToMany(cascade = CascadeType.ALL)
	@Column(name = "studente_id")
	private List<Studente> listaStudenti;

	@ManyToMany
	private List<Libretto> libretto;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public List<Docente> getListaDocente() {
		return listaDocente;
	}

	public void setListaDocente(List<Docente> listaDocente) {
		this.listaDocente = listaDocente;
	}

	public List<Studente> getListaStudenti() {
		return listaStudenti;
	}

	public void setListaStudenti(List<Studente> listaStudenti) {
		this.listaStudenti = listaStudenti;
	}

	public boolean isSuperato() {
		return superato;
	}

	public void setSuperato(boolean superato) {
		this.superato = superato;
	}

	public List<Libretto> getLibretto() {
		return libretto;
	}

	public void setLibretto(List<Libretto> libretto) {
		this.libretto = libretto;
	}
	
	
}
