package org.mihaylov.furniture.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.validation.Valid;

import org.mihaylov.furniture.entity.News;
import org.mihaylov.furniture.service.NewsService;
import org.mihaylov.furniture.utils.PaginationUtils;
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
public class AdminNewsController extends AdminCommon {

	@Autowired
	private NewsService newsService;
	
	@RequestMapping(value = "/news-editor", method = RequestMethod.GET)
	public ModelAndView newsEditor(@RequestParam(required=false) Integer id,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "perpage", required = false) Integer perpage) {
		ModelAndView model = new ModelAndView("admin/news_editor");
		
		Integer cnt = newsService.count();
		PaginationUtils.paginate(model, page, perpage, cnt, "newss",
				newsService.list(PaginationUtils.getStart(page, perpage, newsService.count()), perpage));
		//model.addObject("newss", newsService.list());
		init(model);
		
		if (id != null) {
			model.addObject("edit", true);
			model.addObject("news", newsService.load(id));
		}
		return model;
	}
	
	@RequestMapping(value="/add-news", method=RequestMethod.POST)
	public ModelAndView addNews(@ModelAttribute("news") @Valid News news,
			@RequestParam("image1") MultipartFile image,
			BindingResult result) throws IOException {
		ModelAndView model = new ModelAndView("redirect:/admin/news-editor");

		if (result.hasErrors()) {
			// TODO handle errors
			return model;
		}
		
		newsService.save(news, image);
		return model;
	}
	
	@RequestMapping(value="/edit-news", method=RequestMethod.POST)
	public ModelAndView editNews(@ModelAttribute("news") @Valid News news,
			@RequestParam(value = "keepimg", required = false) Boolean keepimg,
			@RequestParam(value = "image1", required = false) MultipartFile image,
			BindingResult result) throws IOException {
		ModelAndView model = new ModelAndView("redirect:/admin/news-editor");
		if (result.hasErrors()) {
			// TODO handle errors
			return model;
		}
		/*
		 * ≈сли нужно хранить старую картинку
		 * но она нулл, замен€ем им€ пустой строкой
		 * дл€ упрощени€ логики сервиса
		 * »наче если нова€ картинка не указана
		 * ничего не делаем, чтобы не получить
		 * кучу эксепшенов
		 */
		String oldImg = null;
		if (keepimg != null && keepimg) {
			oldImg = newsService.load(news.getId()).getImage();
		} else
			newsService.deleteOldImage(news.getId());
		
		newsService.update(news, image, oldImg);
		return model;
	}
	
	@RequestMapping(value = "/display-news-img-{id}.jpg", method = RequestMethod.GET)
	@ResponseBody
	public byte[] getImage(@PathVariable("id") Integer id) throws IOException {
		Path path = Paths.get(newsService.load(id).getImage());
		byte[] response;
		response = Files.readAllBytes(path);
		return response;
	}
	
	@RequestMapping(value="/delete-news", method=RequestMethod.GET)
	public ModelAndView deleteNews(Integer id) {
		newsService.delete(id);
		return new ModelAndView("redirect:/admin/news-editor");
	}
	
}
