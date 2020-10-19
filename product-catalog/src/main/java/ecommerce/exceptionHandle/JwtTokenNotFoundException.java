package ecommerce.exceptionHandle;

public class JwtTokenNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public JwtTokenNotFoundException(String message) {
		super(message);
	}

}
