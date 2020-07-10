package it.dstech.models;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

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
public class Docente {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "docente_id")
    private Integer id;
	
	@Column(name = "docente_username")
    @Length(min = 5, message = "*Your user name must have at least 5 characters")
    @NotEmpty(message = "*Please provide a user name")
    private String username;
    
    @Column(name = "email_docente")
    @Email(message = "*Please provide a valid Email")
    @NotEmpty(message = "*Please provide an email")
    private String email;
    
    @Column(name = "password_docente")
    @Length(min = 5, message = "*Your password must have at least 5 characters")
    @NotEmpty(message = "*Please provide your password")
    private String password;
    
    @Column(name = "active")
    private Boolean active;

	@ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "docente_role", joinColumns = @JoinColumn(name = "docente_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@Column(name = "esame_id")
	private List<Esame> listaEsame;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	
}
