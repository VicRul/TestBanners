package test.jarsoft.banners.services;

import java.util.List;

import test.jarsoft.banners.dto.CategoryDto;

public interface CategoryService {
	
	CategoryDto createCategory(CategoryDto categoryDto);
	
	void deleteCategory(int categoryId);

	CategoryDto updateCategory(int categoryId, CategoryDto categoryDto);
	
	List<CategoryDto> getAllCategories();
}