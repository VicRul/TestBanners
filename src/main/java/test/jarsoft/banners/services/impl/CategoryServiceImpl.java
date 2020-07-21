package test.jarsoft.banners.services.impl;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
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
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void deleteCategory(Integer categoryId) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}