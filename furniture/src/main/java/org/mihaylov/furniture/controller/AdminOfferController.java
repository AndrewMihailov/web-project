package org.mihaylov.furniture.controller;

import javax.validation.Valid;

import org.mihaylov.furniture.entity.Offer;
import org.mihaylov.furniture.service.CategoryService;
import org.mihaylov.furniture.service.OfferService;
import org.mihaylov.furniture.utils.PaginationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminOfferController extends AdminCommon {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private OfferService offerService;
	
	@RequestMapping(value = "/offers-editor", method = RequestMethod.GET)
	public ModelAndView offersEditor(@RequestParam(required=false) Integer id,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "perpage", required = false) Integer perpage) {
		ModelAndView model = new ModelAndView();
		model.setViewName("admin/offers_editor");
		model.addObject("categories", categoryService.list());
		
		Integer cnt = offerService.count();
		PaginationUtils.paginate(model, page, perpage, cnt, "offers",
				offerService.list(PaginationUtils.getStart(page, perpage, offerService.count()), perpage));
		//model.addObject("offers", offerService.list());
		init(model);
		
		if (id != null) {
			model.addObject("edit", true);
			model.addObject("offer", offerService.load(id));
		}
		return model;
	}
	
	@RequestMapping(value="/add-offer", method=RequestMethod.POST)
	public ModelAndView addOffer(@ModelAttribute("offer") @Valid Offer offer, BindingResult result) {
		ModelAndView model = new ModelAndView("redirect:/admin/offers-editor");
		
		if (result.hasErrors()) {
			// TODO handle errors
			return model;
		}
		
		offerService.save(offer);
		return model;
	}
	
	@RequestMapping(value="/edit-offer", method=RequestMethod.POST)
	public ModelAndView editOffer(@ModelAttribute("offer") @Valid Offer offer, BindingResult result) {
		ModelAndView model = new ModelAndView("redirect:/admin/offers-editor");
		
		if (result.hasErrors()) {
			// TODO handle errors
			return model;
		}
		
		offerService.update(offer);
		return model;
	}
	
	@RequestMapping(value="/delete-offer", method=RequestMethod.GET)
	public ModelAndView deleteAdmin(Integer id) {
		offerService.delete(id);
		return new ModelAndView("redirect:/admin/offers-editor");
	}
}
