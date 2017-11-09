package br.com.cdw.cliente.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import br.com.cdw.cliente.controllers.HomeController;
import br.com.cdw.dao.ClientsDAO;


/*	Usada como classe de configuração do servlet do SpringMVC
 	ComponentScan precisa saber onde procurar os nossos controllers e podemos indicar isso passando um paramêtro. 
 */
@EnableWebMvc
@ComponentScan(basePackageClasses={HomeController.class, ClientsDAO.class})
public class AppWebConfiguration {
	
	// A anotação @Bean é para que o retorno da chamada deste metódo possa ser gerenciada pelo SpringMVC
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver(){
		// InternalResourceViewResolver ajuda o SpringMVC a encontrar as views		
	    InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	    // O setPrefix define o caminho onde estão nossas views
	    resolver.setPrefix("/WEB-INF/views/");
	    // o setSuffix adiciona a extenção dos arquivos de view	    
	    resolver.setSuffix(".jsp");
	    return resolver;
	}
}

