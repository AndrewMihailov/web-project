package org.mihaylov.furniture.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.mihaylov.furniture.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PhotoController {

	@Autowired
	private PhotoService photoService;

	@RequestMapping(value = "/photos", method = RequestMethod.GET)
	public ModelAndView photos(@RequestParam("product_id") Integer productId) {
		ModelAndView model = new ModelAndView("photos");
		model.addObject("photos", photoService.searchByProductId(productId));
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
	
}
