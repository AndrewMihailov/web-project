package org.mihaylov.furniture.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.validation.Valid;

import org.mihaylov.furniture.entity.Product;
import org.mihaylov.furniture.service.CategoryService;
import org.mihaylov.furniture.service.DesignerService;
import org.mihaylov.furniture.service.ProductService;
import org.mihaylov.furniture.utils.PaginationUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminProductController extends AdminCommon {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private DesignerService designerService;

	@Autowired
	private ProductService productService;

	private static final Logger logger = LoggerFactory
			.getLogger(AdminProductController.class);

	@RequestMapping(value = "/product-editor", method = RequestMethod.GET)
	public ModelAndView productEditor(@RequestParam(required = false) Integer id,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "perpage", required = false) Integer perpage) {
		ModelAndView model = new ModelAndView("admin/product_editor");
		model.addObject("categories", categoryService.listOrganized());
		model.addObject("designers", designerService.list());
		
		Integer cnt = productService.count();
		PaginationUtils.paginate(model, page, perpage, cnt, "products",
				productService.list(PaginationUtils.getStart(page, perpage, productService.count()), perpage));
		//model.addObject("products", productService.list());
		init(model);

		if (id != null) {
			model.addObject("edit", true);
			model.addObject("product", productService.load(id));
		}
		return model;
	}

	@RequestMapping(value = "/add-product", method = RequestMethod.POST)
	public ModelAndView addProduct(
			@ModelAttribute("product") @Valid Product product,
			@RequestParam("image1") MultipartFile image, BindingResult result)
			throws IOException {
		ModelAndView model = new ModelAndView("redirect:/admin/product-editor");

		if (result.hasErrors()) {
			// TODO handle errors
			logger.error("mapping error");
			return model;
		}

		productService.save(product, image);
		return model;
	}

	@RequestMapping(value = "/edit-product", method = RequestMethod.POST)
	public ModelAndView editProduct(
			@ModelAttribute("product") @Valid Product product,
			@RequestParam(value = "keepimg", required = false) Boolean keepimg,
			@RequestParam(value = "image1", required = false) MultipartFile image,
			BindingResult result) throws IOException {
		ModelAndView model = new ModelAndView("redirect:/admin/product-editor");

		if (result.hasErrors()) {
			// TODO handle errors
			logger.error("mapping error <=================================================================");
			return model;
		}

		String oldImg = null;
		if (keepimg != null && keepimg) {
			oldImg = productService.load(product.getId()).getImage();
		} else
			productService.deleteOldImage(product.getId());

		productService.update(product, image, oldImg);
		return model;
	}
	
	@RequestMapping(value = "/display-product-img-{id}.jpg", method = RequestMethod.GET)
	@ResponseBody
	public byte[] getImage(@PathVariable("id") Integer id) throws IOException {
		Path path = Paths.get(productService.load(id).getImage());
		byte[] response;
		response = Files.readAllBytes(path);
		return response;
	}

	@RequestMapping(value = "/delete-product", method = RequestMethod.GET)
	public ModelAndView deleteProduct(Integer id) {
		productService.delete(id);
		return new ModelAndView("redirect:/admin/product-editor");
	}

}
