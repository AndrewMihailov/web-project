package org.mihaylov.furniture.controller;

import org.mihaylov.furniture.entity.Designer;
import org.mihaylov.furniture.service.DesignerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminDesignerController extends AdminCommon {
	
	@Autowired
	private DesignerService designerService;
	
	@RequestMapping(value = "/admin/designer-editor", method = RequestMethod.GET)
	public ModelAndView designerEditor() {
		ModelAndView model = new ModelAndView("admin/designer_editor");
		model.addObject("designers", designerService.list());
		init(model);
		return model;
	}
	
	@RequestMapping(value="/admin/add-designer", method=RequestMethod.POST)
	public ModelAndView addDesigner(@ModelAttribute("designer") Designer designer, BindingResult result) {
		ModelAndView model = new ModelAndView("redirect:/admin/designer-editor");
		
		if (result.hasErrors()) {
			// TODO handle errors
			return model;
		}
		
		designerService.save(designer);
		return model;
	}
	
	@RequestMapping(value="/admin/delete-designer", method=RequestMethod.GET)
	public ModelAndView deleteDesigner(Integer id) {
		designerService.delete(id);
		return new ModelAndView("redirect:/admin/designer-editor");
	}
}
