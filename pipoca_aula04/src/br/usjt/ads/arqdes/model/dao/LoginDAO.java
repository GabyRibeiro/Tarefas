package br.usjt.ads.arqdes.model.dao;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.usjt.ads.arqdes.model.entity.Login;

@Repository
public class LoginDAO {
	@PersistenceContext 
	EntityManager manager;
	
	public Login verificaLogin(Login login) throws IOException{
		return manager.find(Login.class, login);
	}
}
