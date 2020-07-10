package it.dstech.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
	
	@JoinTable(name = "nome_esame", joinColumns = @JoinColumn(name = "nome_materia"))
	private String nome;
	
	@Column(name="data_esame")
	private LocalDateTime data;
	
	@Column(name="pass_esame", columnDefinition = "boolean default false")
	private boolean superato;
	
	@Column(name="voto_esame")
	private int voto;

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

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public boolean isSuperato() {
		return superato;
	}

	public void setSuperato(boolean superato) {
		this.superato = superato;
	}

	public int getVoto() {
		return voto;
	}

	public void setVoto(int voto) {
		this.voto = voto;
	}

	
	
	

}
