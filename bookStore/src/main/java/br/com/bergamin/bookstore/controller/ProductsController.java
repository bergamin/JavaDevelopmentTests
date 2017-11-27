package br.com.bergamin.bookstore.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.bergamin.bookstore.dao.ProductDAO;
import br.com.bergamin.bookstore.infra.FileSaver;
import br.com.bergamin.bookstore.model.PriceType;
import br.com.bergamin.bookstore.model.Product;
import br.com.bergamin.bookstore.validation.ProductValidator;

@Controller
@RequestMapping("/products")
public class ProductsController {
	
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private FileSaver fileSaver;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new ProductValidator());
	}
	
	@RequestMapping("form")
	public ModelAndView form(Product product){
		ModelAndView modelAndView = new ModelAndView("products/form");
		modelAndView.addObject("types", PriceType.values());
		return modelAndView;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView save(MultipartFile summary, @Valid Product product, BindingResult result, RedirectAttributes redirectAttributes){
		
		if(result.hasErrors()) {
			return form(product);
		}
		
		product.setSummary(fileSaver.write("summaries", summary));
		
		productDAO.save(product);
		redirectAttributes.addFlashAttribute("success","Product saved!");
		return new ModelAndView("redirect:products");
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView list() {
		List<Product> products = productDAO.list();
		ModelAndView modelAndView = new ModelAndView("products/list");
		modelAndView.addObject("products",products);
		return modelAndView;
	}
	
	@RequestMapping("detail/{id}")
	public ModelAndView detail(@PathVariable("id") Integer id) {
		ModelAndView modelAndView = new ModelAndView("products/detail");
		Product product = productDAO.find(id);
		modelAndView.addObject("product",product);
		
		return modelAndView;
	}
	
}
