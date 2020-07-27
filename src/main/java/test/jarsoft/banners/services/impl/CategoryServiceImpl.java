package test.jarsoft.banners.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import test.jarsoft.banners.domain.Banner;
import test.jarsoft.banners.domain.Category;
import test.jarsoft.banners.dto.BannerDto;
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

		if (duplicateCheck(categoryDto) != null) {
			return duplicateCheck(categoryDto);
		}

		return dtoConverter.categoryToCategoryDto(categoryRepo.save(dtoConverter.categoryDtoToCategory(categoryDto)));

	}

	@Override
	public String deleteCategory(int categoryId) {
		List<BannerDto> notDeletedBanners = notDeletedBanners(categoryId);
		if (notDeletedBanners.isEmpty()) {
			categoryRepo.deleteCategory(categoryId);
			return "Done";
		}
		return notDeletedBanners(categoryId).toString();
	}

	@Override
	public CategoryDto updateCategory(int categoryId, CategoryDto categoryDto) {
		Category categoryFromDB = categoryRepo.findById(categoryId);
		System.out.println(categoryFromDB.toString());
		System.out.println(categoryDto.toString());
		
		if (duplicateCheck(categoryDto) != null) {
			return duplicateCheck(categoryDto);
		}
		
		Category category = dtoConverter.categoryDtoToCategory(categoryDto);
		BeanUtils.copyProperties(category, categoryFromDB);
		return dtoConverter.categoryToCategoryDto(categoryRepo.save(categoryFromDB));
	}

	@Override
	public List<CategoryDto> getAllCategories() {
		return categoryRepo.showAllCategories().stream().map(dtoConverter::categoryToCategoryDto)
				.collect(Collectors.toList());
	}

	@Override
	public List<BannerDto> notDeletedBanners(int categoryId) {
		Category preparedForDeleteon = categoryRepo.findById(categoryId);
		List<Banner> allBannersInThisCategory = preparedForDeleteon.getBanners();
		List<Banner> notDeletedBanners = new ArrayList<>();

		for (Banner banner : allBannersInThisCategory) {
			if (!banner.isDeleted()) {
				notDeletedBanners.add(banner);
			}
		}

		return notDeletedBanners.stream().map(dtoConverter::bannerToBannerDto).collect(Collectors.toList());
	}

	@Override
	public CategoryDto duplicateCheck(CategoryDto categoryDto) {

		Category newCategory = categoryRepo.findByNameOrReqName(categoryDto.getName(), categoryDto.getReqName());
		return (newCategory != null) ? dtoConverter.categoryToCategoryDto(newCategory) : null;
	}
}