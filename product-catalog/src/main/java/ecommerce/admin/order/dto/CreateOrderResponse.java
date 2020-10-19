package ecommerce.admin.order.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateOrderResponse {

	private List<OrderProductDto> list;
	private OrderInfoDto orderDetail;
}
