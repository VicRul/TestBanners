package test.jarsoft.banners.services.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import test.jarsoft.banners.domain.Category;
import test.jarsoft.banners.dto.CategoryDto;
import test.jarsoft.banners.dto.DtoConverter;
import test.jarsoft.banners.repos.CategoryRepo;
import test.jarsoft.banners.services.CategoryService;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

	private final CategoryRepo categoryRepo;
	private final DtoConverter dtoConverter;
	
	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		Category newCategory = categoryRepo.save(dtoConverter.categoryDtoToCategory(categoryDto));
		return dtoConverter.categoryToCategoryDto(newCategory);
	}
	
	@Override
	public void deleteCategory(int categoryId) {
		categoryRepo.deleteCategory(categoryId);
	}
	
	@Override
	public CategoryDto updateCategory(CategoryDto categoryDtoFromDB, CategoryDto categoryDto) {
		Category categoryFromDB = dtoConverter.categoryDtoToCategory(categoryDtoFromDB);
		Category category = dtoConverter.categoryDtoToCategory(categoryDto);
		BeanUtils.copyProperties(category, categoryFromDB, "id");
		return dtoConverter.categoryToCategoryDto(categoryRepo.save(categoryFromDB));
	}	
	
}