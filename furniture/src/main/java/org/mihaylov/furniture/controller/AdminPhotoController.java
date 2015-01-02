package org.mihaylov.furniture.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.validation.Valid;

import org.mihaylov.furniture.entity.Photo;
import org.mihaylov.furniture.entity.Product;
import org.mihaylov.furniture.service.CategoryService;
import org.mihaylov.furniture.service.PhotoService;
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
public class AdminPhotoController extends AdminCommon {

	@Autowired
	private ProductService productService;

	@Autowired
	private PhotoService photoService;
	
	@Autowired
	private CategoryService categoryService;

	private static final Logger logger = LoggerFactory
			.getLogger(AdminPhotoController.class);

	@RequestMapping(value = "/photo-editor", method = RequestMethod.GET)
	public ModelAndView photoEditor(@RequestParam(required = false) Integer id,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "perpage", required = false) Integer perpage) {
		ModelAndView model = new ModelAndView("admin/photo_editor");
		init(model);

		/*model.addObject("groupedProducts",
				productService.listGrouppedProducts());*/
		
		
		Integer cnt = photoService.count();
		PaginationUtils.paginate(model, page, perpage, cnt, "photos",
				photoService.list(PaginationUtils.getStart(page, perpage, photoService.count()), perpage));
		//model.addObject("photos", photoService.list());
		model.addObject("categories", categoryService.listOrganized());

		if (id != null) {
			model.addObject("edit", true);
			model.addObject("photo", photoService.load(id));
		}

		return model;
	}

	@RequestMapping(value = "/add-photo", method = RequestMethod.POST)
	public ModelAndView addPhoto(@ModelAttribute("photo") Photo photo,
			@RequestParam("image1") MultipartFile image, BindingResult result)
			throws IOException {
		ModelAndView model = new ModelAndView("redirect:/admin/photo-editor");
		if (result.hasErrors()) {
			// TODO handle errors
			logger.error("mapping error");
			return model;
		}

		photoService.save(photo, image);
		return model;
	}

	@RequestMapping(value = "/edit-photo", method = RequestMethod.POST)
	public ModelAndView editPhoto(
			@ModelAttribute("photo") @Valid Photo photo,
			@RequestParam(value = "keepimg", required = false) Boolean keepimg,
			@RequestParam(value = "image1", required = false) MultipartFile image,
			BindingResult result) throws IOException {
		ModelAndView model = new ModelAndView("redirect:/admin/photo-editor");

		if (result.hasErrors()) {
			// TODO handle errors
			logger.error("mapping error");
			return model;
		}

		String oldImg = null;
		if (keepimg != null && keepimg) {
			oldImg = photoService.load(photo.getId()).getImage();
		} else
			photoService.deleteOldImage(photo.getId());

		photoService.update(photo, image, oldImg);
		return model;
	}

	@RequestMapping(value = "/display-photo-{id}.jpg", method = RequestMethod.GET)
	@ResponseBody
	public byte[] getImage(@PathVariable("id") Integer id) throws IOException {
		Path path = Paths.get(photoService.load(id).getImage());
		byte[] response;
		response = Files.readAllBytes(path);
		return response;
	}
	
	@RequestMapping(value = "/load-products-from-category", method = RequestMethod.GET)
	@ResponseBody
	public List<Product> getProducts(@RequestParam(value="id") Integer id) {
		return productService.searchByCategoryId(id);
	}

	@RequestMapping(value = "/delete-photo", method = RequestMethod.GET)
	public ModelAndView deletePhoto(Integer id) {
		photoService.delete(id);
		return new ModelAndView("redirect:/admin/photo-editor");
	}

}
