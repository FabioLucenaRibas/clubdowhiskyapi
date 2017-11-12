package br.com.cdw.cliente.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cdw.dao.ClientsDAO;
import br.com.cdw.models.Clients;
import br.com.cdw.models.Users;

/*
 Método Responsável por atender as requisições que chegam na página inicial do nosso projeto, ou seja, o endereço raiz ("/") 
 */
@Controller
public class HomeController {
	/* RequestMapping Tem a função de definir que esse metodo atende a um determinado path ou endereço */
	
	@RequestMapping("/")
    public String index(){
		System.out.println("Entrando na home da CDW");
        
        return "home";
    }
}
