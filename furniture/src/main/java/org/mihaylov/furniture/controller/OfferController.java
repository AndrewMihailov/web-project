package org.mihaylov.furniture.controller;

import java.util.Locale;

import org.mihaylov.furniture.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OfferController extends UserCommon {

	@Autowired
	private OfferService offerService;

	@RequestMapping(value = "/offers", method = RequestMethod.GET)
	public ModelAndView offers(Locale locale) {
		ModelAndView model = new ModelAndView("offers");
		init(model);
		model.addObject("offers", offerService.list(locale));
		return model;
	}
	
}
