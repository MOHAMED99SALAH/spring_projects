package com.boot.delicyfood.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boot.delicyfood.services.OrderService;
import com.boot.delicyfood.services.Order_details_service;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.boot.delicyfood.entities.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Tag(name="Order_Details_Controller ")
@RestController
@RequestMapping("/delicyfood")
@Validated
public class Order_details_controllers {

	
	@Autowired
	private Order_details_service order_details_service;
	
	@Autowired
	private OrderService order_service;
	
	
	@Operation(summary="get last order for specific user by its Email")
	@RequestMapping(value="/lastOrder/{Email}",method =RequestMethod.GET)
	public ResponseEntity<?> getLastOrder (  @Parameter(example="mohamed_123@gmail.com ",name="Email") @PathVariable @Valid @Email String Email )
	{		
		return ResponseEntity.ok(order_details_service.get_User_order(Email));

	}
	
	

	@Operation(summary="get Last Orders of specific user by its Email")
	@RequestMapping(value="/getLastOrders/{Email}",method =RequestMethod.GET)
	public ResponseEntity<?> getLastOrders(@PathVariable @Parameter(example="mohamed_123@gmail.com ",name="Email") @Valid @Email @NotBlank @NotNull String Email)
	{
	
		return ResponseEntity.ok(order_details_service.get_Last_orders(Email));
	}
	
	
}
