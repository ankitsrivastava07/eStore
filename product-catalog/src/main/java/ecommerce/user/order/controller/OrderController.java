package ecommerce.user.order.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ecommerce.common.ObjectTranslator;
import ecommerce.user.order.dto.CreateOrderDto;
import ecommerce.user.order.service.OrderService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/order")
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
	public CreateOrderResponse update(@RequestBody CreateOrderRequest createOrderRequest) {
		CreateOrderDto createOrderDto = objectTranslator.translate(createOrderRequest, CreateOrderDto.class);
		return orderService.update(createOrderDto);
	}

}
