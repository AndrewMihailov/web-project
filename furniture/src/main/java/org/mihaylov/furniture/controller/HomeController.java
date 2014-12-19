package org.mihaylov.furniture.controller;

import java.text.DateFormat;
import java.util.ArrayList;
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
		
		List<News> newsList = newsService.list(locale);
		List<News> newNewsList = new ArrayList<News>();
		int maxNews = 5;
		if (maxNews > newsList.size())
			maxNews = newsList.size();
		for (int i = 0; i < maxNews; i++)
			newNewsList.add(newsList.get(i));
		List<Offer> offerList = offerService.list(locale);
		List<Offer> newOfferList = new ArrayList<Offer>();
		int maxOffers = 5;
		if (maxOffers > offerList.size())
			maxOffers = offerList.size();
		for (int i = 0; i < maxOffers; i++)
			newOfferList.add(offerList.get(i));
		
		model.addObject("news", newNewsList);
		model.addObject("offers", newOfferList);

		return model;
	}

}
