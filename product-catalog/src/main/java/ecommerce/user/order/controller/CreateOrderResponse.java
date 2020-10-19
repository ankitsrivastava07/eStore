package ecommerce.user.order.controller;

import java.time.LocalDateTime;
import java.util.List;

import ecommerce.user.order.dto.DeliveryAddressDto;
import ecommerce.user.order.dto.OrderProductDto;
import ecommerce.user.order.dto.UserDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateOrderResponse {
	private Long id;

	private List<OrderProductDto> order;
	private DeliveryAddressDto address;
	private LocalDateTime createdAt;
	private String status;
	private Double totalAmount;
	private UserDto user;

}
