package ecommerce.admin.order.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeliveryAddress {

	private Long id;
	private String addressLine1;
	private String state;
	private String country;

}
