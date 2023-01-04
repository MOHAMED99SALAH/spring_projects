package com.boot.delicyfood.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.boot.delicyfood.entities.order_details;
import com.boot.delicyfood.repositiries.Order_details_Repo;
@Service
public class Order_details_service {

	@Autowired
	private Order_details_Repo order_details_Repo;
	
	@Autowired
	private OrderService orderService;
	
	
	public List<order_details> get_Last_order(Long id )
	{
	return	order_details_Repo.get_Last_order(id);	
	}
	
	
	
	public List<order_details> get_User_order( String Email)
	{
	
		Long order_ID =orderService.getOrderID(Email);
		
		return get_Last_order(order_ID);
		
	}
	
	
	
	
	public List<order_details> get_Last_orders( String Email)
	{
	
		List<Long> ids =orderService.getOrdersIDS(Email);;
		
		return order_details_Repo.get_All_Last_Orders(ids);
		
	}
	
	
	
	
}
