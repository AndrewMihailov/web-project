package org.mihaylov.furniture.controller;

import javax.validation.Valid;

import org.mihaylov.furniture.entity.Designer;
import org.mihaylov.furniture.service.DesignerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminDesignerController extends AdminCommon {
	
	@Autowired
	private DesignerService designerService;
	
	@RequestMapping(value = "/designer-editor", method = RequestMethod.GET)
	public ModelAndView designerEditor(@RequestParam(required=false) Integer id) {
		ModelAndView model = new ModelAndView("admin/designer_editor");
		model.addObject("designers", designerService.list());
		init(model);
		
		if (id != null) {
			model.addObject("edit", true);
			model.addObject("designer", designerService.load(id));
		}
		return model;
	}
	
	@RequestMapping(value="/add-designer", method=RequestMethod.POST)
	public ModelAndView addDesigner(@ModelAttribute("designer") @Valid Designer designer, BindingResult result) {
		ModelAndView model = new ModelAndView("redirect:/admin/designer-editor");
		
		if (result.hasErrors()) {
			// TODO handle errors
			return model;
		}
		
		designerService.save(designer);
		return model;
	}
	
	@RequestMapping(value="/edit-designer", method=RequestMethod.POST)
	public ModelAndView editDesigner(@ModelAttribute("designer") @Valid Designer designer, BindingResult result) {
		ModelAndView model = new ModelAndView("redirect:/admin/designer-editor");
		
		if (result.hasErrors()) {
			// TODO handle errors
			return model;
		}
		
		designerService.update(designer);
		return model;
	}
	
	@RequestMapping(value="/delete-designer", method=RequestMethod.GET)
	public ModelAndView deleteDesigner(Integer id) {
		designerService.delete(id);
		return new ModelAndView("redirect:/admin/designer-editor");
	}
}
