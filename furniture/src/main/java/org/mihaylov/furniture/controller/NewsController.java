package org.mihaylov.furniture.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;

import org.mihaylov.furniture.service.NewsService;
import org.mihaylov.furniture.utils.PaginationUtils;
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
		
		Integer newsCnt = newsService.count(locale);
		PaginationUtils.paginate(model, page, perpage, newsCnt,
				"news", newsService.list(PaginationUtils.getStart(page, perpage, newsCnt), PaginationUtils.PERPAGE, locale));
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
