package dev.alperdonmez.ecommerceordermanagement;

import dev.alperdonmez.ecommerceordermanagement.core.exceptions.BusinessException;
import dev.alperdonmez.ecommerceordermanagement.core.exceptions.ProblemDetails;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@SpringBootApplication
@RestControllerAdvice
public class ECommerceOrderManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECommerceOrderManagementApplication.class, args);
	}
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}

	@ExceptionHandler(BusinessException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ProblemDetails handleBusinessException(BusinessException businessException) {
		ProblemDetails problemDetails = new ProblemDetails();
		problemDetails.setMessage(businessException.getMessage());
		return problemDetails;
	}
}
