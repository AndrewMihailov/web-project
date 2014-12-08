package org.mihaylov.furniture.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mihaylov.furniture.entity.Category;
import org.mihaylov.furniture.entity.Photo;
import org.mihaylov.furniture.entity.Product;
import org.mihaylov.furniture.service.CategoryService;
import org.mihaylov.furniture.service.PhotoService;
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
public class AdminPhotoController extends AdminCommon {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private PhotoService photoService;
	
	private static final Logger logger = LoggerFactory
			.getLogger(AdminPhotoController.class);
	
	@RequestMapping(value = "/admin/photo-editor", method = RequestMethod.GET)
	public ModelAndView photoEditor() {
		ModelAndView model = new ModelAndView("admin/photo_editor");
		init(model);
		
		Map<String, List<Product>> groupedProducts = new HashMap<String, List<Product>>();
		
		for (Category category : categoryService.list()) {
			groupedProducts.put(category.getName(), productService.searchByCategoryId(category.getId()));
			logger.info(productService.searchByCategoryId(category.getId()).toString());
		}
		
		model.addObject("groupedProducts", groupedProducts);
		model.addObject("photos", photoService.list());
		
		return model;
	}
	
	@RequestMapping(value="/admin/add-photo", method=RequestMethod.POST)
	public ModelAndView addPhoto(@ModelAttribute("photo") Photo photo, BindingResult result) {
		ModelAndView model = new ModelAndView("redirect:/admin/photo-editor");
		
		if (result.hasErrors()) {
			// TODO handle errors
			logger.error("mapping error");
			return model;
		}
		
		photoService.save(photo);
		return model;
	}
	
	@RequestMapping(value="/admin/delete-photo", method=RequestMethod.GET)
	public ModelAndView deletePhoto(Integer id) {
		photoService.delete(id);
		return new ModelAndView("redirect:/admin/photo-editor");
	}

}
