package test.jarsoft.banners.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import test.jarsoft.banners.domain.Category;
import test.jarsoft.banners.repos.CategoryRepo;
import test.jarsoft.banners.services.CategoryService;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

	private final CategoryRepo categoryRepo;
	
	@Override
	public Category createCategory(Category category) {
		return categoryRepo.save(category);
	}
	
	@Override
	public void deleteCategory(int categoryId) {
		categoryRepo.deleteCategory(categoryId);
	}
	
	@Override
	public Category updateCategory(int categoryId, Category category) {
		Category categoryFromDB = categoryRepo.findById(categoryId);
		BeanUtils.copyProperties(category, categoryFromDB);
		return categoryRepo.save(categoryFromDB);
	}

	@Override
	public List<Category> getAllCategories() {
		return categoryRepo.showAllCategories()
				.stream()
				.collect(Collectors.toList());
	}	
	
}