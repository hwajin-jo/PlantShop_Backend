package com.example.demo.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.OrderFormDto;
import com.example.demo.model.Address;
import com.example.demo.model.Faq;
import com.example.demo.model.Notice;
import com.example.demo.model.Order;
import com.example.demo.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
@Controller
@RequestMapping("/api")
public class OrderController {

	@Autowired
	OrderRepository orderRepository;

//	@GetMapping("/orders")
//	public ResponseEntity<Order> getOrder(){
//		List<Order> orders = orderRepository.findAll();
//		return new ResponseEntity<>(HttpStatus.OK);
//	}

//	@PostMapping("/orders")
//	public ResponseEntity<Order> pushOrder(@RequestBody OrderFormDto dto, String username){
//		Order neworder = new Order();
//		neworder.setUsername(username);
//		neworder.setOName(dto.getOName());
//		neworder.setOAddress(dto.getOAddress());
//		neworder.setOPhone(dto.getOPhone());
//		neworder.setOPost(dto.getOPost());
//		neworder.setOPayment(dto.getOPayment());
//		neworder.setODate(dto.getODate());
//		
//		orderRepository.save(neworder);
//		
//		return new ResponseEntity<>(HttpStatus.OK);
//	}

	@GetMapping("/orders/list/{username}")
	public ResponseEntity<List<Order>> orderList(@RequestParam(required = false) String oname,
			@PathVariable("username") String username) {
		try {
			List<Order> order = new ArrayList<Order>();

			orderRepository.findAllByUsername(username).forEach(order::add);
			if (order.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(order, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/addorder")
	public ResponseEntity<Order> createFaq(@RequestBody Order order) {

		try { 

			Order _order = this.orderRepository.save(new Order(order.getPid(),order.getPname(), order.getPprice(),order.getOcount(),order.getOtotal(),order.getPimg1(), LocalDate.now(), order.getUsername()));
			return new ResponseEntity<>(_order, HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@GetMapping("/orders/list")
	public ResponseEntity<List<Order>> list(@RequestParam(required = false) String pname) {
		try {
			List<Order> order = new ArrayList<Order>();
			if (pname == null)
				orderRepository.findAll().forEach(order::add);
			else
				orderRepository.findByPnameContaining(pname).forEach(order::add);
			if (order.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(order, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}
