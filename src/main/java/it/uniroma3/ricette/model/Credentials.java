package it.uniroma3.ricette.model;

import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Credentials {

	public static final String ADMIN_ROLE = "ADMIN";
	public static  final String USER_ROLE = "USER";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotBlank
	@NotNull
	@NotEmpty
	private String username;
	
	@Size(min = 8,  message="La password deve essere di almeno 8 caratteri")
	@NotNull
	@NotBlank
	private String password;
	
	private String role;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "utente_id")
	private Cuoco cuoco;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Cuoco getCuoco() {
		return cuoco;
	}

	public void setCuoco(Cuoco cuoco) {
		this.cuoco = cuoco;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(cuoco, id, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Credentials other = (Credentials) obj;
		return Objects.equals(cuoco, other.cuoco) && Objects.equals(id, other.id)
				&& Objects.equals(username, other.username);
	}
	
	
	
}
