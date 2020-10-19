package ecommerce.exceptionHandle;

public class JwtTokenMalformedException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public JwtTokenMalformedException(String message) {
		super(message);
	}

}