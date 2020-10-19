package ecommerce.admin.order.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeliveryAddressDto {

	private String addressLine1;
	private Integer stateId;
	private Integer countryId;


}
