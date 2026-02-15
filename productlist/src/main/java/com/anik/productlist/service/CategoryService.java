package com.anik.productlist.service;

import com.anik.productlist.dto.CategoryDTO;
import com.anik.productlist.dto.ProductDTO;
import com.anik.productlist.entity.Category;
import com.anik.productlist.mapper.CategoryMapper;
import com.anik.productlist.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {
    private CategoryRepository categoryRepository;
    // Create Category
    public CategoryDTO createCategory(CategoryDTO categoryDTO){
        Category category = CategoryMapper.toCategoryEntity(categoryDTO);
        category =  categoryRepository.save(category);
        return CategoryMapper.toCategoryDTO(category);
    }

    // Get all Category
    public List<CategoryDTO> getAllCategories(){
        List<CategoryDTO> categoryDTOList = categoryRepository.findAll()
                .stream()
                .map(CategoryMapper::toCategoryDTO)
                .toList();
        return categoryDTOList;
    }

    // Get Category by Id
    public CategoryDTO getCategoryById(Long id){
        Category category = categoryRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Category Not Found"));
        return CategoryMapper.toCategoryDTO(category);
    }

    // Delete Category
    public String deleteCategory(Long id){
        categoryRepository.deleteById(id);
        return "Category "+id+" has been deleted.";
    }
}
