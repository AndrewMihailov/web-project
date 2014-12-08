package org.mihaylov.furniture.controller;

import org.mihaylov.furniture.entity.News;
import org.mihaylov.furniture.service.NewsService;
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
public class AdminNewsController extends AdminCommon {

	private static final Logger logger = LoggerFactory
			.getLogger(AdminNewsController.class);
	
	@Autowired
	private NewsService newsService;
	
	@RequestMapping(value = "/admin/news-editor", method = RequestMethod.GET)
	public ModelAndView newsEditor() {
		ModelAndView model = new ModelAndView("admin/news_editor");
		model.addObject("news", newsService.list());
		init(model);
		return model;
	}
	
	@RequestMapping(value="/admin/add-news", method=RequestMethod.POST)
	public ModelAndView addNews(@ModelAttribute("news") News news, BindingResult result) {
		ModelAndView model = new ModelAndView("redirect:/admin/news-editor");

		if (result.hasErrors()) {
			// TODO handle errors
			return model;
		}
		
		logger.info("Text:" + news.getText());
		
		//newsService.addNews(news);
		return model;
	}
	
}
