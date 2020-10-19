package ecommerce.admin.order.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ecommerce.admin.order.dto.CreateOrderDto;
import ecommerce.admin.order.dto.CreateOrderResponse;
import ecommerce.admin.order.service.OrderService;
import ecommerce.common.ObjectTranslator;
import lombok.AllArgsConstructor;

@RestController(value="orderController2")
@RequestMapping("admin/order")
@AllArgsConstructor

public class OrderController {
	private ObjectTranslator objectTranslator;
	private OrderService orderService;

	@PostMapping
	public CreateOrderResponse create(@RequestBody CreateOrderRequest createOrderRequest) {
		CreateOrderDto createOrderDto = objectTranslator.translate(createOrderRequest, CreateOrderDto.class);
		CreateOrderResponse res = orderService.create(createOrderDto);
		return res;
	}

	@GetMapping("/cancel/{orderId}")
	public void cancelOrder(@PathVariable("orderId") Long orderId) {
		orderService.cancelOrder(orderId);
	}

	@PutMapping
	public void update(@RequestBody CreateOrderRequest createOrderRequest) {
		CreateOrderDto createOrderDto = objectTranslator.translate(createOrderRequest, CreateOrderDto.class);
		orderService.update(createOrderDto);
	}

}
