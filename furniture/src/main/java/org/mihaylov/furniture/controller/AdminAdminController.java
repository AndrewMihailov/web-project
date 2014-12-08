package org.mihaylov.furniture.controller;

import org.mihaylov.furniture.entity.Admin;
import org.mihaylov.furniture.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminAdminController extends AdminCommon {

	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value = "/admin/admin-editor", method = RequestMethod.GET)
	public ModelAndView adminEditor() {
		ModelAndView model = new ModelAndView("admin/admin_editor");
		model.addObject("admins", adminService.list());
		init(model);
		return model;
	}
	
	@RequestMapping(value="/admin/add-admin", method=RequestMethod.POST)
	public ModelAndView addAdmin(@ModelAttribute("admin") Admin admin, BindingResult result) {
		ModelAndView model = new ModelAndView("redirect:/admin/admin-editor");
		
		if (result.hasErrors()) {
			// TODO handle errors
			return model;
		}
		
		adminService.save(admin);
		return model;
	}
	
	@RequestMapping(value="/admin/delete-admin", method=RequestMethod.GET)
	public ModelAndView deleteAdmin(Integer id) {
		adminService.delete(id);
		return new ModelAndView("redirect:/admin/admin-editor");
	}
	
	@RequestMapping(value="/admin/get-admin", method=RequestMethod.GET)
	public @ResponseBody Admin getAdmin(@RequestParam Integer id) {
	    return adminService.get(id);
	}
}
