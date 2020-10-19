package ecommerce.common;

public class ProductOutOfStock extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ProductOutOfStock(String message) {
		super(message);
	}

}
