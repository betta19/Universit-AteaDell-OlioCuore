package it.dstech.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Libretto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@ManyToMany
	public List<User> user;
	
	@ManyToMany
	public List<Esame> esame;
	
	public int voto;
	
	private double media;
	
	public double getMedia() {
		return media;
	}

	public void setMedia(double media) {
		this.media = media;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Esame> getEsame() {
		return esame;
	}

	public void setEsame(List<Esame> esame) {
		this.esame = esame;
	}

	public int getVoto() {
		return voto;
	}

	public void setVoto(int voto) {
		this.voto = voto;
	}
}
