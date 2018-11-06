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
	@Size(max=20)
	private String login;
	@NotNull
	@Size(max=20)
	private String senha;
}
