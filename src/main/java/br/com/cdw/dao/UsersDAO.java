package br.com.cdw.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.cdw.models.Clients;
import br.com.cdw.models.Users;

@Repository
@Transactional
public class UsersDAO {
	// O EntityManager é um gerenciador de entidades e é usado para persistir no banco de dados
	@PersistenceContext
	private EntityManager eManager;
	
	public void save(Clients client){
		eManager.persist(client);		
	}
	
	public Users findOne(Integer id) {
		return eManager.find(Users.class, id);
	}
}
