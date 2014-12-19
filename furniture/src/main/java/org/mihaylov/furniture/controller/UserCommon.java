package org.mihaylov.furniture.controller;

import org.mihaylov.furniture.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserCommon {

	@Autowired
	private CategoryService categoryService;
	
	protected void init(ModelAndView model) {
		model.addObject("menuCategories", categoryService.listOrganized());
	}
}
