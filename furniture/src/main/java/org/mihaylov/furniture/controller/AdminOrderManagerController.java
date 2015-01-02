package org.mihaylov.furniture.controller;

import org.mihaylov.furniture.entity.Order;
import org.mihaylov.furniture.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminOrderManagerController extends AdminCommon {
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value = { "/order-manager" }, method = RequestMethod.GET)
	public ModelAndView orderManager(
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "perpage", required = false) Integer perpage) {
		ModelAndView model = new ModelAndView();
		model.setViewName("admin/order_manager");
		init(model);
		
		/*Integer cnt = orderService.count();
		PaginationUtils.paginate(model, page, perpage, cnt, "orders",
				orderService.list(PaginationUtils.getStart(page, perpage, orderService.count()), perpage));*/
		model.addObject("orders", orderService.list());
		
		return model;
	}
	
	@RequestMapping(value = { "/fulfill-order" }, method = RequestMethod.GET)
	public ModelAndView fulfilOrder(Integer id, Boolean val) {
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/admin/order-manager");
		Order order = orderService.load(id);
		order.setFulfilled(val);
		orderService.update(order);
		return model;
	}
	
	@RequestMapping(value = { "/delete-order" }, method = RequestMethod.GET)
	public ModelAndView deleteOrder(Integer id) {
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/admin/order-manager");
		orderService.delete(id);
		return model;
	}

}
