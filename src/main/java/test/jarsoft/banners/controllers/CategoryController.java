package test.jarsoft.banners.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import test.jarsoft.banners.dto.CategoryDto;
import test.jarsoft.banners.services.CategoryService;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryController {

	private final CategoryService categoryService;
	
	@GetMapping
	public List<CategoryDto> getAllCategories() {
		return categoryService.getAllCategories();
		
	}
	
	@PostMapping
	public CategoryDto createCategory(@RequestBody CategoryDto categoryDto) {
		return categoryService.createCategory(categoryDto);
	}
	
	@PutMapping("/{id}")
	public String deleteCategory(@PathVariable("id") int categoryId) {
		return categoryService.deleteCategory(categoryId);
	}
	
	@PutMapping("/update/{id}")
	public CategoryDto updateCategory(
			@PathVariable("id") int categoryId, 
			@RequestBody CategoryDto categoryDto
			) {
		return categoryService.updateCategory(categoryId, categoryDto);
	}
	
}