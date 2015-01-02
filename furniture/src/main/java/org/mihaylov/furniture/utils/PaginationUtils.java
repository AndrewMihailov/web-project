package org.mihaylov.furniture.utils;

import org.springframework.web.servlet.ModelAndView;

public class PaginationUtils {
	
	final static public Integer PERPAGE = 5;
	final static public Integer PRODUCTS_PERPAGE = 24;

	static public Integer getStart(Integer page, Integer perpage, Integer total) {
		if (page == null)
			page = 1;
		if (perpage == null)
			perpage = PaginationUtils.PERPAGE;
		int start = (page - 1) * perpage;
		if (start > total) {
			start = 0;
			page = 1;
		}
		return start;
	}

	static public void paginate(ModelAndView model, Integer page,
			Integer perpage, Integer total, String listName,
			Object objects) {
		if (page == null)
			page = 1;
		if (perpage == null)
			perpage = PaginationUtils.PERPAGE;

		model.addObject(listName, objects);
		model.addObject("page", page);
		model.addObject("perpage", perpage);
		model.addObject("totalPages", (total - 1) / perpage + 1);
		
		System.out.println("total pages " + ((total - 1) / perpage + 1));
	}

}
