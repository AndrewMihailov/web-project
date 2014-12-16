package org.mihaylov.furniture.controller;

import javax.validation.Valid;

import org.mihaylov.furniture.entity.Contact;
import org.mihaylov.furniture.service.ContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminContactController extends AdminCommon {
	
	@Autowired
	private ContactService contactService;
	
	private static final Logger logger = LoggerFactory
			.getLogger(AdminContactController.class);
	
	
	@RequestMapping(value = "/contact-editor", method = RequestMethod.GET)
	public ModelAndView contactEditor(@RequestParam(required=false) Integer id) {
		ModelAndView model = new ModelAndView("admin/contact_editor");
		model.addObject("contacts", contactService.list());
		init(model);
		
		if (id != null) {
			model.addObject("edit", true);
			model.addObject("contact", contactService.load(id));
		}
		
		return model;
	}
	
	@RequestMapping(value="/add-contact", method=RequestMethod.POST)
	public ModelAndView addContact(@ModelAttribute("contact") @Valid Contact contact, BindingResult result) {
		ModelAndView model = new ModelAndView("redirect:/admin/contact-editor");
		
		if (result.hasErrors()) {
			// TODO handle errors
			logger.info("validation error");
			return model;
		}
		contactService.save(contact);
		return model;
	}
	
	@RequestMapping(value="/edit-contact", method=RequestMethod.POST)
	public ModelAndView editContact(@Valid @ModelAttribute("contact") Contact contact, BindingResult result) {
		ModelAndView model = new ModelAndView("redirect:/admin/contact-editor");
		
		if (result.hasErrors()) {
			// TODO handle errors
			return model;
		}
		contactService.update(contact);
		return model;
	}
	
	@RequestMapping(value = "/delete-contact", method = RequestMethod.GET)
	public ModelAndView deleteContact(Integer id) {
		ModelAndView model = new ModelAndView("redirect:/admin/contact-editor");
		contactService.delete(id);
		return model;
	}

}
