package br.com.cdw.cliente.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.cdw.dao.UsersDAO;
import br.com.cdw.models.Users;

@RestController
public class UsersController {
	@Autowired
	private UsersDAO usersDAO;
	
	@RequestMapping("/user/{id}")
	@ResponseBody
	public ModelAndView listClient(@PathVariable("id") int id){
		ModelAndView modelAndView = new ModelAndView("user/index");
		Users users = usersDAO.findOne(id);
		modelAndView.addObject("users", users);
		
		return modelAndView;
	}
}
