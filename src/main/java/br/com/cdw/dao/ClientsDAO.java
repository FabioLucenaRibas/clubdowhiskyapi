package br.com.cdw.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.cdw.models.Clients;
import br.com.cdw.models.Drinks;

@Repository
@Transactional
public class ClientsDAO {
	// O EntityManager é um gerenciador de entidades e é usado para persistir no banco de dados
	@PersistenceContext
	private EntityManager eManager;
	
	public void save(Clients client){
		eManager.persist(client);		
	}
	
	public Clients findOne(Integer id) {
		return eManager.find(Clients.class, id);
	}
	
	public Clients findClientByUser(String email, String senha){
		return (Clients) eManager.createQuery("select c from Clients c where c.user.email =:email and c.user.senha =:senha")
				.setParameter("email", email)
				.setParameter("senha", senha)
				.getSingleResult();
	}
}
