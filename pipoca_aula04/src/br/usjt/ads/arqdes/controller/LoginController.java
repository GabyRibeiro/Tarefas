package br.usjt.ads.arqdes.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.usjt.ads.arqdes.model.entity.Login;
import br.usjt.ads.arqdes.model.service.LoginService;



@Controller
public class LoginController {
	@Autowired
	private LoginService lService;

	 @RequestMapping("efetuaLogin")
     public String efetuaLogin(Login login, HttpSession session) throws IOException {
         if(lService.verificaLogin(login) != null) {
             session.setAttribute("usuarioLogado", login);
             return "index";
         }
         return "redirect:login";
     }
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
}
