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
@Table(name = "materia")
public class Materia {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "materia_id")
    private Integer id;
	
	@Column(name = "nome_materia")
	private String nomeMateria;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@Column(name = "docente_id")
	private List<Docente> listaDocente;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@Column(name = "esame_id")
	private List<Esame> listaEsame;

	public Integer getId() {
		return id;
	}

	public void setIdMateria(Integer id) {
		this.id = id;
	}

	public String getNomeMateria() {
		return nomeMateria;
	}

	public void setNomeMateria(String nomeMateria) {
		this.nomeMateria = nomeMateria;
	}

	public List<Docente> getListaDocente() {
		return listaDocente;
	}

	public void setListaDocente(List<Docente> listaDocente) {
		this.listaDocente = listaDocente;
	}

	public List<Esame> getListaEsame() {
		return listaEsame;
	}

	public void setListaEsame(List<Esame> listaEsame) {
		this.listaEsame = listaEsame;
	}
	
	

}
