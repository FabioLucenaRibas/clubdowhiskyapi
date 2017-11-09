package br.com.cdw.cliente.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cdw.dao.ClientsDAO;
import br.com.cdw.models.Clients;

@Controller
public class ClientsController {
	
	/*
	 A anotação @Autowired serve para que nós não nos preocupemos em criar manualmente o 
	 ClientsDAO no Controller. O Spring fará isso automaticamente. Mas para isso, o Spring precisa 
	 "conhecer" o ClientsDAO. Em outras palavras dizemos que devemos definir que o ClientsDAO será gerenciado pelo Spring. 
	 Para isso devemos marcar o ClientsDAO com a anotação @Repository */
	@Autowired
	private ClientsDAO clientsDao;
	
	@RequestMapping
	public String save(Clients client){
		System.out.println(client);
		clientsDao.save(client);
		return "/clients/ok";
		
	}
}
