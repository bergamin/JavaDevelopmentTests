package br.com.bergamin.bookstore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import br.com.bergamin.bookstore.controller.HomeController;
import br.com.bergamin.bookstore.dao.ProductDAO;

@EnableWebMvc
@ComponentScan(basePackageClasses={HomeController.class,ProductDAO.class})
public class AppWebConfigurator {
	
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/view/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
}
