package com.anik.productlist.controller;

import com.anik.productlist.dto.ProductDTO;
import com.anik.productlist.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name="Product REST API CRUD Operation",
        description = "CREAtE, REATD, UPDATE, DELETE operations for Product REST API"
)
@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {

    private ProductService productService;
    // Create Product
    @Operation(
            summary = "Create Product",
            description = "REST API to Create product"
    )
    @ApiResponse(
            responseCode = "201",
            description = "CREATED"
    )
    @PreAuthorize("hasAuthority('ROLE_SELLER')")
    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO){
        return new ResponseEntity<>(productService.createProduct(productDTO), HttpStatus.CREATED);
    }

    // Get All Product
    @Operation(
            summary = "Fetch all products",
            description = "REST API to fetch all products."
    )
    @GetMapping
    public List<ProductDTO> getAllProduct(){
        return productService.getAllProduct();
    }

    // Get Product by Id
    @Operation(
            summary = "Fetch product by Id",
            description = "REST API to fetch product by Id"
    )
    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }

    // Update product by Id
    @Operation(
            summary = "Update product by Id",
            description = "REST API to update product by product Id"
    )
    @PreAuthorize("hasAuthority('ROLE_SELLER')")
    @PutMapping("/{id}")
    public ProductDTO updateProductById(@PathVariable Long id, @RequestBody ProductDTO productDTO){
        return productService.updateProductById(id, productDTO);
    }

    // Delete Product by Id
    @Operation(
            summary = "Delete product by Id",
            description = "REST API to delete product by Id."
    )
    @PreAuthorize("hasAuthority('ROLE_SELLER')")
    @DeleteMapping("/{id}")
    public String deleteProductById(@PathVariable Long id){
        return productService.deleteProductById(id);
    }
}
