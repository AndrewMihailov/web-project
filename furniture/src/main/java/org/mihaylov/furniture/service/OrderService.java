package org.mihaylov.furniture.service;

import org.mihaylov.furniture.dao.OrderDao;
import org.mihaylov.furniture.dao.ProductDao;
import org.mihaylov.furniture.entity.Order;
import org.mihaylov.furniture.entity.OrderProducts;
import org.mihaylov.furniture.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("orderService")
public class OrderService {
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private ProductDao productDao;
	
	@Transactional
	public void save(Order order) {
		order.setTotal(0);
		if (order.getProducts().size() == 0)
			return;
		
		int sum = 0;
		for (OrderProducts product : order.getProducts()) {
			Product pr = product.getProduct();
			if (pr == null)
				System.out.println("=================================== NULL =================================");
			else {
				Integer price = pr.getPrice();
				if (price == null)
					System.out.println("=================================== price is NULL =================================");
				else
					sum += price;
			}
		}
			
		order.setTotal(new Integer(sum));
		
		orderDao.save(order);
	}
}
