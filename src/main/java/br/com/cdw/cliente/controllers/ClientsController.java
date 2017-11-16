package br.com.cdw.cliente.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.cdw.dao.ClientsDAO;
import br.com.cdw.models.Clients;

@RestController
public class ClientsController {
	
	/*
	 A anotação @Autowired serve para que nós não nos preocupemos em criar manualmente o 
	 ClientsDAO no Controller. O Spring fará isso automaticamente. Mas para isso, o Spring precisa 
	 "conhecer" o ClientsDAO. Em outras palavras dizemos que devemos definir que o ClientsDAO será gerenciado pelo Spring. 
	 Para isso devemos marcar o ClientsDAO com a anotação @Repository */
	@Autowired
	private ClientsDAO clientsDAO;
	
	@RequestMapping("/client/{id}")
	@ResponseBody
	public ModelAndView listClient(@PathVariable("id") int id){
		ModelAndView modelAndView = new ModelAndView("client/list");
		Clients clients = clientsDAO.findOne(id);
		modelAndView.addObject("clients", clients);
		
		return modelAndView;
	}

}
