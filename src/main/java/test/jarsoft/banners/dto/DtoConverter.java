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
				.build();			
	}
	
	public Banner bannerDtoToBanner(BannerDto bannerDto) {
		Banner banner = new Banner();
		
		banner.setContent(bannerDto.getContent());
		banner.setName(bannerDto.getName());
		banner.setPrice(bannerDto.getPrice());
		
		return banner;
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
		Category category = new Category();
		
		category.setName(categoryDto.getName());
		category.setReqName(categoryDto.getName());
		
		return category;
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
		Request request = new Request();
		
		request.setIpAddress(requestDto.getIpAddress());
		request.setUserAgent(requestDto.getUserAgent());
		
		return request;
	}
}