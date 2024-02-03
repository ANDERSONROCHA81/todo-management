package net.javaguides.todo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Spring Boot Todo Management REST API Documentation",
				description = "Spring Boot Todo Management REST API Documentation",
				version = "v1.0",
				contact = @Contact(
						name = "Anderson",
						email = "ironmanrocha81@gmail.com"
				),
				license = @License(
						name = "Apache 2.0"
				)
		)
)
public class TodoManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoManagementApplication.class, args);
	}

}
