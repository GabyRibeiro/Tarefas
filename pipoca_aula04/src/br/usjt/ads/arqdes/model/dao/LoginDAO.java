package br.usjt.ads.arqdes.model.dao;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.usjt.ads.arqdes.model.entity.Filme;

@Repository
public class LoginDAO {
	@PersistenceContext 
	EntityManager manager;
	

}
