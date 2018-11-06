package br.usjt.ads.arqdes.model.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import br.usjt.ads.arqdes.model.dao.LoginDAO;
import br.usjt.ads.arqdes.model.entity.Login;

public class LoginService {
	@Autowired
	private LoginDAO dao;

	public Login verificaLogin(Login login) throws IOException {
		// TODO Auto-generated method stub
		return dao.verificaLogin(login);
	}
}
