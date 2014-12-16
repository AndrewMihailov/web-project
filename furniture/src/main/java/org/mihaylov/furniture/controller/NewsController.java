package org.mihaylov.furniture.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;

import org.mihaylov.furniture.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NewsController {

	@Autowired
	private NewsService newsService;

	@RequestMapping(value = "/news", method = RequestMethod.GET)
	public ModelAndView news(Locale locale) {
		ModelAndView model = new ModelAndView("news");
		model.addObject("news", newsService.list(locale));
		return model;
	}
	
	@RequestMapping(value = "/news-page", method = RequestMethod.GET)
	public ModelAndView newsPage(Integer id) {
		ModelAndView model = new ModelAndView("news_page");
		model.addObject("news", newsService.load(id));
		return model;
	}
	
	@RequestMapping(value = "/display-news-img-{id}.jpg", method = RequestMethod.GET)
	@ResponseBody
	public byte[] getImage(@PathVariable("id") Integer id) throws IOException {
		Path path = Paths.get(newsService.load(id).getImage());
		byte[] response;
		response = Files.readAllBytes(path);
		return response;
	}
	
}
