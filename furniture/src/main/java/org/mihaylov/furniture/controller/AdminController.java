package org.mihaylov.furniture.controller;

import org.mihaylov.furniture.entity.Admin;
import org.mihaylov.furniture.entity.News;
import org.mihaylov.furniture.service.IAdminService;
import org.mihaylov.furniture.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

	@Autowired
	private IAdminService adminService;
	
	@Autowired
	private NewsService newsService;
	
	@RequestMapping(value = {"/admin", "/admin/home"}, method = RequestMethod.GET)
	public ModelAndView adminHome() {
		ModelAndView model = new ModelAndView();
		model.addObject("message", "Admin home page");
		model.setViewName("admin/home");
		return model;
	}
	
	@RequestMapping(value = "/admin/admin-editor", method = RequestMethod.GET)
	public ModelAndView adminEditor() {
		ModelAndView model = new ModelAndView("admin/admin_editor");
		model.addObject("admins", adminService.listAdmin());
		return model;
	}
	
	@RequestMapping(value = "/admin/news-editor", method = RequestMethod.GET)
	public ModelAndView newsEditor() {
		ModelAndView model = new ModelAndView("admin/news_editor");
		model.addObject("news", newsService.listNews());
		return model;
	}
	
	@RequestMapping(value = "/admin/offers-editor", method = RequestMethod.GET)
	public ModelAndView offersEditor() {
		ModelAndView model = new ModelAndView();
		model.setViewName("admin/offers_editor");
		return model;
	}
	
	@RequestMapping(value = "/admin/product-editor", method = RequestMethod.GET)
	public ModelAndView productEditor() {
		ModelAndView model = new ModelAndView();
		model.setViewName("admin/product_editor");
		return model;
	}
	
	@RequestMapping(value="/admin/add-admin", method=RequestMethod.POST)
	public ModelAndView addAdmin(@ModelAttribute("admin") Admin admin, BindingResult result) {
		ModelAndView model = new ModelAndView("redirect:/admin/admin-editor");
		
		if (result.hasErrors()) {
			// TODO handle errors
			return model;
		}
		
		adminService.addAdmin(admin);
		return model;
	}
	
	@RequestMapping(value="/admin/add-news", method=RequestMethod.POST)
	public ModelAndView addNews(@ModelAttribute("news") News news, BindingResult result) {
		ModelAndView model = new ModelAndView("redirect:/admin/news-editor");
		
		if (result.hasErrors()) {
			// TODO handle errors
			return model;
		}
		
		newsService.addNews(news);
		return model;
	}
	
}
