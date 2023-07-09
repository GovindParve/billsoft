package com.bill_soft.exception;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
@RestControllerAdvice
public class GlobalExceptionHandlerController {
	public DefaultErrorAttributes  errorattributes() {
		return new DefaultErrorAttributes()
		
				{
			public Map<String,Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) 
			{
				Map<String,Object> errorattributes =(Map<String, Object>) super.getError(webRequest);
				errorattributes.remove("exception");
				return errorattributes;
			}
				};
	}
	
	 @ExceptionHandler(CustomException.class)
	  public void handleCustomException(HttpServletResponse res, CustomException ex) throws IOException {
	    res.sendError(ex.getHttpStatus().value(), ex.getMessage());
	  }

//	 @ExceptionHandler(MethodArgumentNotValidException.class)
//	 public ResponseEntity<Map<String,String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex)
//{
//		Map<String,String> resp=new HashMap<>();
//     ((Object) ex).getBindingResult().getMessage().getAllErrors().forEach((error) ->
//	 {
//		String fieldName=((FieldError) error).getField();
//		String message=error.getDefaultMessage();
//		resp.put(fieldName, message);
//		
//		});
//		return new ResponseEntity<Map<String,String>>(resp.HttpStatus.BAD_REQUEST.value()) ;
//}
	 @ExceptionHandler(ConstraintViolationException.class)
		 public ResponseEntity<String> constraintViolation(ConstraintViolationException ex){
				return new ResponseEntity<String>(ex.getMessage(),HttpStatus.BAD_REQUEST);
			}
//		 @ExceptionHandler(ConstraintViolationException.class)
//		 @ResponseStatus(HttpStatus.BAD_REQUEST)
//		    @ResponseBody
//	 ValidationFailedResponse onConstraintValidationException(ConstraintViolationException e) {
//	        ValidationFailedResponse error = new ValidationFailedResponse(null);
//	        for (ConstraintViolation<?> violation: e.getConstraintViolations()) {
//	            error.getViolations().add(new ValidationErrors(violation.getPropertyPath().toString(), violation.getMessage()));
//	        }
//	        return error;
//	    }
//		
//	   @ExceptionHandler(MethodArgumentNotValidException.class)
//	    @ResponseStatus(HttpStatus.BAD_REQUEST)
//	    @ResponseBody
//	    ValidationFailedResponse onMethodArgumentNotValidException(MethodArgumentNotValidException e) {
//	        ValidationFailedResponse error = new ValidationFailedResponse(null);
//	        for (FieldError fieldError: e.getBindingResult().getFieldErrors()) {
//	            error.getViolations().add(new ValidationErrors(fieldError.getField(), fieldError.getDefaultMessage()));
//	        }
//	        return error;
//	    }
//	


	 
	  @ExceptionHandler(AccessDeniedException.class)
	  public void handleAccessDeniedException(HttpServletResponse res) throws IOException {
	    res.sendError(HttpStatus.FORBIDDEN.value(), "Access denied");
	  }

	  @ExceptionHandler(Exception.class)
	  public void handleException(HttpServletResponse res) throws IOException {
	    res.sendError(HttpStatus.BAD_REQUEST.value(), "Something went wrong");
	  }


}