package it.dstech.models;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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

	private Integer id;

	private String nome;

	private String data;

	@Column(columnDefinition = "boolean default false")
	private boolean iscritto;
	
	@ManyToMany(cascade = CascadeType.ALL)

	private List<User> listaUser; // intesa come lista studenti

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

	public List<User> getListaUser() {
		return listaUser;
	}

	public void setListaUser(List<User> listaUser) {
		this.listaUser = listaUser;
	}

	public boolean isIscritto() {
		return iscritto;
	}

	public void setIscritto(boolean iscritto) {
		this.iscritto = iscritto;
	}

	public List<Libretto> getLibretto() {
		return libretto;
	}

	public void setLibretto(List<Libretto> libretto) {
		this.libretto = libretto;
	}
	
	
}
