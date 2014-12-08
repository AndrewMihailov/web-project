package org.mihaylov.furniture.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminHomeController extends AdminCommon {
	
	@RequestMapping(value = { "/admin", "/admin/home" }, method = RequestMethod.GET)
	public ModelAndView adminHome() {
		ModelAndView model = new ModelAndView();
		model.addObject("message", "Admin home page");
		model.setViewName("admin/home");
		init(model);
		return model;
	}

}
