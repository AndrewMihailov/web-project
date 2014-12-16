package org.mihaylov.furniture.controller;

import org.mihaylov.furniture.entity.Order;
import org.mihaylov.furniture.entity.Product;
import org.mihaylov.furniture.service.OrderService;
import org.mihaylov.furniture.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;

	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/order", method = RequestMethod.GET)
	public ModelAndView order() {
		ModelAndView model = new ModelAndView("order");
		model.addObject("groupedProducts",
				productService.listGrouppedProducts());
		return model;
	}
	
	@RequestMapping(value = "/make-order", method = RequestMethod.POST)
	public ModelAndView makeOrder(@ModelAttribute("order") Order order, BindingResult result) {
		ModelAndView model = new ModelAndView("redirect:/order");
		orderService.save(order);
		return model;
	}

	@RequestMapping(value = "/get-product", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Product getProduct(@RequestParam Integer id) {
		return productService.load(id);
	}

}
