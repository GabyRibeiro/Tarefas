package br.usjt.ads.arqdes.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
@Table(name="Usuario")
public class Login {
	@Id
	@NotNull
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@NotNull
	@Size(max=50)
	private String login;
	@NotNull
	@Size(max=50)
	private String senha;
	@NotNull
	@Size(max=50)
	private String nomeUsuario;
	@NotNull
	@Size(max=50)
	private String tipoUsuario;
	@Override
	public String toString() {
		return "Login [id=" + id + ", login=" + login + ", senha=" + senha + ", nomeUsuario=" + nomeUsuario
				+ ", tipoUsuario=" + tipoUsuario + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	public String getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
}
