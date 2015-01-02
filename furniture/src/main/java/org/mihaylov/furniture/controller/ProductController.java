package org.mihaylov.furniture.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.mihaylov.furniture.entity.Product;
import org.mihaylov.furniture.service.PhotoService;
import org.mihaylov.furniture.service.ProductService;
import org.mihaylov.furniture.utils.PaginationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController extends UserCommon {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private PhotoService photoService;

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ModelAndView products(@RequestParam(required = false) Integer id,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "perpage", required = false) Integer perpage) {
		ModelAndView model = new ModelAndView("products");
		init(model);
		
		List<Product> list;
		Integer cnt = productService.count();
		
		if (id == null)
			list = productService.list(PaginationUtils.getStart(page, PaginationUtils.PRODUCTS_PERPAGE, cnt),
					PaginationUtils.PRODUCTS_PERPAGE);
		else
			list = productService.searchByCategoryId(id,
					PaginationUtils.getStart(page, PaginationUtils.PRODUCTS_PERPAGE, cnt),
					PaginationUtils.PRODUCTS_PERPAGE);
		
		PaginationUtils.paginate(model, page, PaginationUtils.PRODUCTS_PERPAGE, cnt, "products", list);
		model.addObject("currId", id);
		return model;
	}
	
	@RequestMapping(value = "/product-page", method = RequestMethod.GET)
	public ModelAndView productPage(@RequestParam(required = false) Integer id) {
		ModelAndView model = new ModelAndView("product_page");
		if (id == null)
			return new ModelAndView("redirect:/products");
		init(model);
		model.addObject("product", productService.load(id));
		model.addObject("photos", photoService.searchByProductId(id));
		
		return model;
	}
	
	@RequestMapping(value = "/display-photo-{id}.jpg", method = RequestMethod.GET)
	@ResponseBody
	public byte[] getPhoto(@PathVariable("id") Integer id) throws IOException {
		Path path = Paths.get(photoService.load(id).getImage());
		byte[] response;
		response = Files.readAllBytes(path);
		return response;
	}
	
	@RequestMapping(value = "/display-product-img-{id}.jpg", method = RequestMethod.GET)
	@ResponseBody
	public byte[] getImage(@PathVariable("id") Integer id) throws IOException {
		Path path = Paths.get(productService.load(id).getImage());
		byte[] response;
		response = Files.readAllBytes(path);
		return response;
	}
	
}
