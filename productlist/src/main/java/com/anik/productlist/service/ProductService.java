package com.anik.productlist.service;

import com.anik.productlist.dto.ProductDTO;
import com.anik.productlist.entity.Category;
import com.anik.productlist.entity.Product;
import com.anik.productlist.mapper.ProductMapper;
import com.anik.productlist.repository.CategoryRepository;
import com.anik.productlist.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductService {
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    public ProductDTO createProduct(ProductDTO productDTO){

        Category category = categoryRepository.findById(productDTO.getCategoryId())
                .orElseThrow(()-> new RuntimeException("Category Not Found."));
        Product product = ProductMapper.toProductEntity(productDTO, category);
        product = productRepository.save(product);
        return ProductMapper.toProductDTO(product);
    }
}
