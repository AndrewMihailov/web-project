package org.mihaylov.furniture.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.mihaylov.furniture.entity.News;
import org.mihaylov.furniture.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NewsController extends UserCommon {

	@Autowired
	private NewsService newsService;

	@RequestMapping(value = "/news", method = RequestMethod.GET)
	public ModelAndView news(Locale locale,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "perpage", required = false) Integer perpage) {
		ModelAndView model = new ModelAndView("news");
		init(model);
		
		if (page == null)
			page = 1;
		if (perpage == null)
			perpage = 10;
	
		List<News> list = newsService.list(locale);
		int start = (page - 1) * perpage;
		if (start > list.size()) {
			start = 0;
			page = 1;
		}
		int end = start + perpage;
		if (end > list.size())
			end = list.size();
		List<News> newList = new ArrayList<News>();
		for (int i = start; i < end; i++)
			newList.add(list.get(i));
		
		model.addObject("news", newList);
		model.addObject("page", page);
		model.addObject("perpage", perpage);
		model.addObject("totalPages", (list.size() - 1) / perpage + 1);
		return model;
	}

	@RequestMapping(value = "/news-page", method = RequestMethod.GET)
	public ModelAndView newsPage(@RequestParam(required = false) Integer id) {
		ModelAndView model = new ModelAndView("news_page");
		if (id == null)
			return new ModelAndView("redirect:/news");
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
