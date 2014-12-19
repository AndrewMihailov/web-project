package org.mihaylov.furniture.service;

import java.util.List;

import org.mihaylov.furniture.dao.OrderDao;
import org.mihaylov.furniture.dao.ProductDao;
import org.mihaylov.furniture.entity.Order;
import org.mihaylov.furniture.entity.OrderProducts;
import org.mihaylov.furniture.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSendException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("orderService")
public class OrderService {
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private JavaMailSenderImpl mailSender;
	
	@Transactional
	public void save(Order order) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("vaaeppeort@gmail.com");
		message.setSubject("New order");
		message.setText(String.format("New order made by %s and avaible at admin panal", order.getFio()));
		message.setTo("mihaylov.andrey.a@gmail.com");
		
		try {
			mailSender.send(message);
		} catch (MailSendException e) {
			e.printStackTrace();
		}
		
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
	
	@Transactional
	public List<Order> list() {
		return orderDao.list();
	}
	
	@Transactional
	public Order load(Integer id) {
		return orderDao.load(id);
	}
	
	@Transactional
	public void update(Order order) {
		orderDao.update(order);
	}
	
	@Transactional
	public void delete(Integer id) {
		orderDao.delete(orderDao.load(id));
	}
}
