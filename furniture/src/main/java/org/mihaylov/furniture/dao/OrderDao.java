package org.mihaylov.furniture.dao;

import org.mihaylov.furniture.entity.Order;

public class OrderDao extends GenericDao<Order, Integer> {

	public OrderDao() {
		super(Order.class);
	}

}
