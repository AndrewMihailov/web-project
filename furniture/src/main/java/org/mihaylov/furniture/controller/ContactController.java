package org.mihaylov.furniture.controller;

import java.util.Locale;

import org.mihaylov.furniture.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContactController extends UserCommon {

	@Autowired
	private ContactService contactService;

	@RequestMapping(value = "/contacts", method = RequestMethod.GET)
	public ModelAndView contacts(Locale locale) {
		ModelAndView model = new ModelAndView("contacts");
		init(model);
		model.addObject("contacts", contactService.list(locale));
		return model;
	}
	
}
