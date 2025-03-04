package com.restart.loans;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.stereotype.Component;


@SpringBootApplication(scanBasePackages = {
		"com.restart.loans"})
@OpenAPIDefinition(
		info =@Info(
				version = "v1.0",
				description = "Loans",
				title = "Loans",
				contact = @Contact(
						email = "gagangaliveeti1234@gmail.com",
						url = "https:/8090/hi"
				),
				license = @License(
						name = "Gagan",
						url = "gagan//8090.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				url ="http:1999/2001.com",
				description = "Project"
		)
)
@EnableMongoAuditing(auditorAwareRef = "auditAwareImpl")
public class LoansApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoansApplication.class, args);
	}

}
