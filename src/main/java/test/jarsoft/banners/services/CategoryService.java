package test.jarsoft.banners.services;

import test.jarsoft.banners.dto.CategoryDto;

public interface CategoryService {
	
	CategoryDto createCategory(CategoryDto categoryDto);
	
	void deleteCategory(int categoryId);

	CategoryDto updateCategory(CategoryDto categoryDtoFromDB, CategoryDto categoryDto);
}