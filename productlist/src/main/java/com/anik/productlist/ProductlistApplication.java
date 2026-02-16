package com.anik.productlist;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Product Service REST API documentation",
                description = "Product service REST API",
                version = "v1",
                contact = @Contact(
                        name = "nazmul anik",
                        email = "nazzmul.anik@gmail.com"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "sharepoint URL Product Service API",
                url = "example.com"
        )
)
public class ProductlistApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductlistApplication.class, args);
    }

}
