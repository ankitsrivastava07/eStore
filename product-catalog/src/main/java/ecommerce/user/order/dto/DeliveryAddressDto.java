package ecommerce.user.order.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeliveryAddressDto {

	private Long Id;
	private String addressLine1;
	private String state;
	private String country;

}
