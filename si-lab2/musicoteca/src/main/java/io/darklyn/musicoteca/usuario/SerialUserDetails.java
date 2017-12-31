package io.darklyn.musicoteca.usuario;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class SerialUserDetails extends org.springframework.security.core.userdetails.User {

	private Integer id;
	private String nome;
	
	public SerialUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities, Integer id, String nome) {
		super(username, password, authorities);
		this.id = id;
		this.nome = nome;
	}

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

}
