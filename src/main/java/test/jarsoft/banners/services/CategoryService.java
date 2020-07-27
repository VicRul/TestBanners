package test.jarsoft.banners.services;

import java.util.List;

import test.jarsoft.banners.dto.BannerDto;
import test.jarsoft.banners.dto.CategoryDto;

public interface CategoryService {
	
	CategoryDto createCategory(CategoryDto categoryDto);
	
	String deleteCategory(int categoryId);

	CategoryDto updateCategory(int categoryId, CategoryDto categoryDto);
	
	List<CategoryDto> getAllCategories();
	
	List<BannerDto> notDeletedBanners(int id);
	
	CategoryDto duplicateCheck(CategoryDto categoryDto);
}