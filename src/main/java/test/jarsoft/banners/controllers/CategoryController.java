package test.jarsoft.banners.controllers;

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
	
	@PostMapping("/save")
	public CategoryDto createCategory(@RequestBody CategoryDto categoryDto) {
		return categoryService.createCategory(categoryDto);
	}
	
	@PutMapping("/delete/{id}")
	public void deleteCategory(@PathVariable int categoryId) {
		categoryService.deleteCategory(categoryId);
	}
	
	@PutMapping("/update/{id}")
	public CategoryDto updateCategory(
			@PathVariable("id") CategoryDto categoryFromDB, 
			@RequestBody CategoryDto category
			) {
		return categoryService.updateCategory(categoryFromDB, category);
	}
	
}