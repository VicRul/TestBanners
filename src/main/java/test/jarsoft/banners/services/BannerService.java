package test.jarsoft.banners.services;

import java.util.List;

import test.jarsoft.banners.dto.BannerDto;

public interface BannerService {

	BannerDto createBanner(BannerDto bannerDto);

	void deleteBanner(int bannerId);

	BannerDto updateBanner(int bannerId, BannerDto bannerDto);

	List<BannerDto> getAllBanners();
}