package org.mihaylov.furniture.controller;

import org.mihaylov.furniture.entity.Offer;
import org.mihaylov.furniture.service.CategoryService;
import org.mihaylov.furniture.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminOfferController extends AdminCommon {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private OfferService offerService;
	
	@RequestMapping(value = "/admin/offers-editor", method = RequestMethod.GET)
	public ModelAndView offersEditor() {
		ModelAndView model = new ModelAndView();
		model.setViewName("admin/offers_editor");
		model.addObject("categories", categoryService.list());
		model.addObject("offers", offerService.list());
		init(model);
		return model;
	}
	
	@RequestMapping(value="/admin/add-offer", method=RequestMethod.POST)
	public ModelAndView addOffer(@ModelAttribute("offer") Offer offer, BindingResult result) {
		ModelAndView model = new ModelAndView("redirect:/admin/offers-editor");
		
		if (result.hasErrors()) {
			// TODO handle errors
			return model;
		}
		
		offerService.save(offer);
		return model;
	}
	
	@RequestMapping(value="/admin/delete-offer", method=RequestMethod.GET)
	public ModelAndView deleteAdmin(Integer id) {
		offerService.delete(id);
		return new ModelAndView("redirect:/admin/offers-editor");
	}
}
