package org.mihaylov.furniture.controller;

import javax.validation.Valid;

import org.mihaylov.furniture.entity.Admin;
import org.mihaylov.furniture.service.AdminService;
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
public class AdminAdminController extends AdminCommon {

	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value = "/admin-editor", method = RequestMethod.GET)
	public ModelAndView adminEditor(@RequestParam(required=false) Integer id,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "perpage", required = false) Integer perpage) {
		ModelAndView model = new ModelAndView("admin/admin_editor");
		
		Integer cnt = adminService.count();
		PaginationUtils.paginate(model, page, perpage, cnt, "admins",
				adminService.list(PaginationUtils.getStart(page, perpage, adminService.count()), perpage));
		//model.addObject("admins", adminService.list());
		init(model);
		
		if (id != null) {
			model.addObject("edit", true);
			model.addObject("admin", adminService.load(id));
		}
		return model;
	}
	
	@RequestMapping(value="/add-admin", method=RequestMethod.POST)
	public ModelAndView addAdmin(@ModelAttribute("admin") @Valid Admin admin, BindingResult result) {
		ModelAndView model = new ModelAndView("redirect:/admin/admin-editor");
		
		if (result.hasErrors()) {
			// TODO handle errors
			return model;
		}
		
		adminService.save(admin);
		return model;
	}
	
	@RequestMapping(value="/edit-admin", method=RequestMethod.POST)
	public ModelAndView editAdmin(@ModelAttribute("admin") @Valid Admin admin, BindingResult result) {
		ModelAndView model = new ModelAndView("redirect:/admin/admin-editor");
		
		if (result.hasErrors()) {
			// TODO handle errors
			return model;
		}
		
		adminService.update(admin);
		return model;
	}
	
	@RequestMapping(value="/delete-admin", method=RequestMethod.GET)
	public ModelAndView deleteAdmin(Integer id) {
		adminService.delete(id);
		return new ModelAndView("redirect:/admin/admin-editor");
	}
}
