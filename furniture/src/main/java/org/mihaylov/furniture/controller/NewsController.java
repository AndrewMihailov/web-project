package org.mihaylov.furniture.controller;

import org.mihaylov.furniture.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NewsController {

	@Autowired
	private NewsService newsService;

	@RequestMapping(value = "/news", method = RequestMethod.GET)
	public ModelAndView news() {
		ModelAndView model = new ModelAndView("news");
		model.addObject("news", newsService.list());
		return model;
	}
	
	@RequestMapping(value = "/news-page", method = RequestMethod.GET)
	public ModelAndView newsPage(Integer id) {
		ModelAndView model = new ModelAndView("news_page");
		model.addObject("news", newsService.get(id));
		return model;
	}
	
}
