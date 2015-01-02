package org.mihaylov.furniture.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.mihaylov.furniture.entity.News;
import org.mihaylov.furniture.entity.Offer;
import org.mihaylov.furniture.service.NewsService;
import org.mihaylov.furniture.service.OfferService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController extends UserCommon {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);
	
	@Autowired
	private NewsService newsService;
	
	@Autowired
	private OfferService offerService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(Locale locale) {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		logger.info("home page opened at " + formattedDate);
		logger.info("locale " + locale);
		
		ModelAndView model = new ModelAndView("home");
		init(model);
		
		Integer perPage = 5;
		List<News> newsList = newsService.list(0, perPage, locale);
		List<Offer> offerList = offerService.list(0, perPage, locale);
		
		model.addObject("news", newsList);
		model.addObject("offers", offerList);

		return model;
	}

}
