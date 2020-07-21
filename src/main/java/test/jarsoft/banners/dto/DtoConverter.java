package test.jarsoft.banners.dto;

import org.springframework.stereotype.Component;

import test.jarsoft.banners.domain.Banner;
import test.jarsoft.banners.domain.Category;
import test.jarsoft.banners.domain.Request;

@Component
public class DtoConverter {

	public BannerDto bannerToBannerDto(Banner banner) {
		return BannerDto.builder()
				.id(banner.getId())
				.name(banner.getName())
				.price(banner.getPrice())
				.content(banner.getContent())
				.deleted(banner.isDeleted())
				.categoryDto(categoryToCategoryDto(banner.getCategory()))
				.build();
	}
	
	public Banner bannerDtoToBanner(BannerDto bannerDto) {
		return Banner.builder()
				.id(bannerDto.getId())
				.name(bannerDto.getName())
				.price(bannerDto.getPrice())
				.content(bannerDto.getContent())
				.deleted(bannerDto.isDeleted())
				.category(categoryDtoToCategory(bannerDto.getCategoryDto()))
				.build();
	}
	
	public CategoryDto categoryToCategoryDto(Category category) {
		return CategoryDto.builder()
				.id(category.getId())
				.name(category.getName())
				.reqName(category.getReqName())
				.deleted(category.isDeleted())
				.build();
	}
	
	public Category categoryDtoToCategory(CategoryDto categoryDto) {
		return Category.builder()
				.id(categoryDto.getId())
				.name(categoryDto.getName())
				.reqName(categoryDto.getReqName())
				.deleted(categoryDto.isDeleted())
				.build();
	}
	
	public RequestDto requestToRequestDto(Request request) {
		return RequestDto.builder()
				.id(request.getId())
				.bannerDto(bannerToBannerDto(request.getBanner()))
				.userAgent(request.getUserAgent())
				.ipAddress(request.getIpAddress())
				.date(request.getDate())
				.build();
	}
	
	public Request requestDtoToRequest(RequestDto requestDto) {
		return Request.builder()
				.id(requestDto.getId())
				.banner(bannerDtoToBanner(requestDto.getBannerDto()))
				.userAgent(requestDto.getUserAgent())
				.ipAddress(requestDto.getIpAddress())
				.date(requestDto.getDate())
				.build();
	}
}