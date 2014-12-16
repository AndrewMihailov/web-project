package org.mihaylov.furniture.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.mihaylov.furniture.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ModelAndView products() {
		ModelAndView model = new ModelAndView("products");
		model.addObject("products", productService.list());
		return model;
	}
	
	@RequestMapping(value = "/product-page", method = RequestMethod.GET)
	public ModelAndView productPage(Integer id) {
		ModelAndView model = new ModelAndView("product_page");
		model.addObject("product", productService.load(id));
		return model;
	}
	
	@RequestMapping(value = "/display-product-img-{id}.jpg", method = RequestMethod.GET)
	@ResponseBody
	public byte[] getImage(@PathVariable("id") Integer id) throws IOException {
		Path path = Paths.get(productService.load(id).getImage());
		byte[] response;
		response = Files.readAllBytes(path);
		return response;
	}
	
}
