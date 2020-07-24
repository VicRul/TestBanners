package test.jarsoft.banners.services;

import java.util.List;

import test.jarsoft.banners.domain.Category;

public interface CategoryService {
	
	Category createCategory(Category categoryDto);
	
	void deleteCategory(int categoryId);

	Category updateCategory(int categoryId, Category category);
	
	List<Category> getAllCategories();
}