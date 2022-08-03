package s3.vietan.user.management.common;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
//	@ExceptionHandler(value = {NotFoundException.class})
//	public Object handleNotFoundException(NotFoundException e) {
//		
//		return ResponseHandler.getErrorResponse(e.getMessage(), HttpStatus.NOT_FOUND);
//	}
//	
//	@ExceptionHandler(value= {Exception.class})
//	public Object handleUnexpectException(Exception e) {
//		
//		return ResponseHandler.getErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST);
//	}
//	
//	@ExceptionHandler(value = {RuntimeException.class})
//	public Object handleElearningRuntimeException(RuntimeException e) {
//		return ResponseHandler.getErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST);
//	}
}
