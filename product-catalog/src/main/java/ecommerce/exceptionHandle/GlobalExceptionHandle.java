package ecommerce.exceptionHandle;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import ecommerce.common.ApiError;
import ecommerce.common.ProductOutOfStock;

@ControllerAdvice
public class GlobalExceptionHandle {
	@Autowired
	private HttpServletRequest path;

	@ExceptionHandler(ProductOutOfStock.class)
	public ResponseEntity<ApiError> productOutOfStock(ProductOutOfStock ex) {
		ApiError error = new ApiError(new Date(), HttpStatus.OK.value(), HttpStatus.OK.name(), ex.getMessage(),
				path.getRequestURI());

		return new ResponseEntity<>(error, HttpStatus.OK);

	}

	@ExceptionHandler(UserNameNotFoundException.class)
	public ResponseEntity<ApiError> userNotFound(ProductOutOfStock ex) {
		ApiError error = new ApiError(new Date(), HttpStatus.OK.value(), HttpStatus.OK.name(), ex.getMessage(),
				path.getRequestURI());
		return new ResponseEntity<>(error, HttpStatus.OK);

	}

}
