package org.mihaylov.furniture.controller;

import org.mihaylov.furniture.entity.Product;
import org.mihaylov.furniture.service.CategoryService;
import org.mihaylov.furniture.service.DesignerService;
import org.mihaylov.furniture.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminProductsController extends AdminCommon {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private DesignerService designerService;
	
	@Autowired
	private ProductService productService;
	
	private static final Logger logger = LoggerFactory
			.getLogger(AdminProductsController.class);

	@RequestMapping(value = "/admin/product-editor", method = RequestMethod.GET)
	public ModelAndView productEditor() {
		ModelAndView model = new ModelAndView("admin/product_editor");
		model.addObject("categories", categoryService.list());
		model.addObject("designers", designerService.list());
		model.addObject("products", productService.list());
		init(model);
		return model;
	}
	
	@RequestMapping(value="/admin/add-product", method=RequestMethod.POST)
	public ModelAndView addProduct(@ModelAttribute("product") Product product, BindingResult result) {
		ModelAndView model = new ModelAndView("redirect:/admin/product-editor");
		
		if (result.hasErrors()) {
			// TODO handle errors
			logger.error("mapping error");
			return model;
		}
		
		productService.save(product);
		return model;
	}
	
	@RequestMapping(value="/admin/delete-product", method=RequestMethod.GET)
	public ModelAndView deleteProduct(Integer id) {
		productService.delete(id);
		return new ModelAndView("redirect:/admin/product-editor");
	}
	
}
