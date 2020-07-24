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
import test.jarsoft.banners.domain.Category;
import test.jarsoft.banners.services.CategoryService;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryController {

	private final CategoryService categoryService;
	
	@GetMapping
	public List<Category> getAllCategories() {
		return categoryService.getAllCategories();
		
	}
	
	@PostMapping
	public Category createCategory(@RequestBody Category category) {
		return categoryService.createCategory(category);
	}
	
	@PutMapping("/{id}")
	public void deleteCategory(@PathVariable("id") int categoryId) {
		categoryService.deleteCategory(categoryId);
	}
	
	@PutMapping("/delete/{id}")
	public Category updateCategory(
			@PathVariable("id") int categoryId, 
			@RequestBody Category category
			) {
		return categoryService.updateCategory(categoryId, category);
	}
	
}