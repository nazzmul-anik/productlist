package com.anik.productlist.service;

import com.anik.productlist.dto.ProductDTO;
import com.anik.productlist.entity.Category;
import com.anik.productlist.entity.Product;
import com.anik.productlist.mapper.ProductMapper;
import com.anik.productlist.repository.CategoryRepository;
import com.anik.productlist.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    // Create Product
    public ProductDTO createProduct(ProductDTO productDTO){

        Category category = categoryRepository.findById(productDTO.getCategoryId())
                .orElseThrow(()-> new RuntimeException("Category not found!"));
        Product product = ProductMapper.toProductEntity(productDTO, category);
        product = productRepository.save(product);
        return ProductMapper.toProductDTO(product);
    }

    // Get all product
    public List<ProductDTO> getAllProduct(){
        return productRepository.findAll()
                .stream().map(ProductMapper::toProductDTO).toList();
    }

    // Get Product by Id
    public ProductDTO getProductById(Long id){
        Product product = productRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Product not found!"));
        return ProductMapper.toProductDTO(product);
    }

    // Update product by Id
    public ProductDTO updateProductById(Long id, ProductDTO productDTO){
        Product product = productRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Product not found!"));
        Category category = categoryRepository.findById(productDTO.getCategoryId())
                .orElseThrow(()-> new RuntimeException("Category not found!"));
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setCategory(category);
        productRepository.save(product);
        return ProductMapper.toProductDTO(product);
    }

    // Delete Product by Id
    public String deleteProductById(Long id){
        productRepository.deleteById(id);
        return "Product "+id+" has been deleted successfully!";
    }
}
