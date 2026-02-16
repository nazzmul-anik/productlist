package com.anik.productlist.controller;

import com.anik.productlist.dto.ProductDTO;
import com.anik.productlist.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {

    private ProductService productService;
    // Create Product
    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO){
        return new ResponseEntity<>(productService.createProduct(productDTO), HttpStatus.CREATED);
    }

    // Get All Product
    @GetMapping
    public List<ProductDTO> getAllProduct(){
        return productService.getAllProduct();
    }

    // Get Product by Id
    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }

    // Update product by Id
    @PutMapping("/{id}")
    public ProductDTO updateProductById(@PathVariable Long id, @RequestBody ProductDTO productDTO){
        return productService.updateProductById(id, productDTO);
    }

    // Delete Product by Id
    @DeleteMapping("/{id}")
    public String deleteProductById(@PathVariable Long id){
        return productService.deleteProductById(id);
    }
}
