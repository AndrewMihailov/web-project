package org.mihaylov.furniture.controller;

import javax.validation.Valid;

import org.mihaylov.furniture.entity.Category;
import org.mihaylov.furniture.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminCategoryController extends AdminCommon {
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value = "/category-editor", method = RequestMethod.GET)
	public ModelAndView categoryEditor(@RequestParam(required=false) Integer id) {
		ModelAndView model = new ModelAndView("admin/category_editor");
		model.addObject("categories", categoryService.list());
		init(model);
		
		if (id != null) {
			model.addObject("edit", true);
			model.addObject("category", categoryService.load(id));
		}
		return model;
	}
	
	@RequestMapping(value="/add-category", method=RequestMethod.POST)
	public ModelAndView addCategory(@ModelAttribute("category") @Valid Category category, BindingResult result) {
		ModelAndView model = new ModelAndView("redirect:/admin/category-editor");
		
		if (result.hasErrors()) {
			// TODO handle errors
			return model;
		}
		
		categoryService.save(category);
		return model;
	}
	
	@RequestMapping(value="/edit-category", method=RequestMethod.POST)
	public ModelAndView editCategory(@ModelAttribute("category") @Valid Category category, BindingResult result) {
		ModelAndView model = new ModelAndView("redirect:/admin/category-editor");
		
		if (result.hasErrors()) {
			// TODO handle errors
			System.out.println("mapping error <==============================================================");
			return model;
		}
		
		categoryService.update(category);
		return model;
	}
	
	@RequestMapping(value="/delete-category", method=RequestMethod.GET)
	public ModelAndView deleteCategory(Integer id) {
		categoryService.delete(id);
		return new ModelAndView("redirect:/admin/category-editor");
	}
}
