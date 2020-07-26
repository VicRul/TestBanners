package test.jarsoft.banners.services;

import java.util.List;

import test.jarsoft.banners.domain.Banner;

public interface BannerService {

	Banner createBanner(Banner bannerDto);

	void deleteBanner(long bannerId);

	Banner updateBanner(long bannerId, Banner banner);

	List<Banner> getAllBanners();
}