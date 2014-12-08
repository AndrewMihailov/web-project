package org.mihaylov.furniture.controller;

import org.mihaylov.furniture.entity.Contact;
import org.mihaylov.furniture.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminContactController extends AdminCommon {
	
	@Autowired
	private ContactService contactService;
	
	@RequestMapping(value = "/admin/contact-editor", method = RequestMethod.GET)
	public ModelAndView contactEditor() {
		ModelAndView model = new ModelAndView("admin/contact_editor");
		model.addObject("contacts", contactService.list());
		init(model);
		return model;
	}
	
	@RequestMapping(value="/admin/add-contact", method=RequestMethod.POST)
	public ModelAndView addContact(@ModelAttribute("contact") Contact contact, BindingResult result) {
		ModelAndView model = new ModelAndView("redirect:/admin/contact-editor");
		
		if (result.hasErrors()) {
			// TODO handle errors
			return model;
		}
		contactService.save(contact);
		return model;
	}
	
	@RequestMapping(value = "/admin/delete-contact", method = RequestMethod.GET)
	public ModelAndView deleteContact(Integer id) {
		ModelAndView model = new ModelAndView("redirect:/admin/contact-editor");
		contactService.delete(id);
		return model;
	}

}
