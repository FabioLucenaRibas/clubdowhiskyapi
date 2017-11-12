package br.com.cdw.cliente.conf;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
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
		/* 	- InternalResourceViewResolver ajuda o SpringMVC a encontrar as views		
	     	- O setPrefix define o caminho onde estão nossas views
	     	- O setSuffix adiciona a extenção dos arquivos de view*/
		
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	    resolver.setPrefix("/WEB-INF/views/");
	    resolver.setSuffix(".jsp");
	    return resolver;
	}
	
	@Bean
	public ViewResolver contentNegotiationViewResolver(ContentNegotiationManager manager) {
		List<ViewResolver> viewResolvers = new ArrayList<>();
		viewResolvers.add(internalResourceViewResolver());
		viewResolvers.add(new JsonViewResolver());
		
		ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
		resolver.setViewResolvers(viewResolvers);
		resolver.setContentNegotiationManager(manager);
		
		return resolver;
	}
	
	@Bean
	public RestTemplate restTemplate() {
	        return new RestTemplate();
	}
}

