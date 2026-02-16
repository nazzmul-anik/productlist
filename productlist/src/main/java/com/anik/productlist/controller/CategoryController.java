package com.anik.productlist.controller;

import com.anik.productlist.dto.CategoryDTO;
import com.anik.productlist.entity.Category;
import com.anik.productlist.exception.CategoryExistsException;
import com.anik.productlist.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name="Category REST API CRUD Operation",
        description = "CREAtE, REATD, UPDATE, DELETE operations for Category REST API"
)
@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryController {

    private CategoryService categoryService;

    // Create Category
    @Operation(
            summary = "Create Category",
            description = "REST API to Create Category"
    )
    @ApiResponse(
            responseCode = "201",
            description = "CREATED"
    )
    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO){
        return new ResponseEntity<>(categoryService.createCategory(categoryDTO), HttpStatus.CREATED);
    }

    // Get All Category
    @Operation(
            summary = "Fetch all Categories",
            description = "REST API to fetch all categories."
    )
    @GetMapping
    public List<CategoryDTO> getAllCategories(){
        return categoryService.getAllCategories();
    }

    // Get Category by id
    @Operation(
            summary = "Fetch Category by Id",
            description = "REST API to fetch category by Id"
    )
    @GetMapping("/{id}")
    public CategoryDTO getCategoryById(@PathVariable Long id){
        return categoryService.getCategoryById(id);
    }

    // Delete Category
    @Operation(
            summary = "Delete Category by Id",
            description = "REST API to delete category by Id."
    )
    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable Long id){
        return categoryService.deleteCategory(id);
    }
}
