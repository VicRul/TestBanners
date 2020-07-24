package test.jarsoft.banners.services;

import java.util.List;

import test.jarsoft.banners.domain.Banner;

public interface BannerService {

	Banner createBanner(Banner bannerDto);

	void deleteBanner(int bannerId);

	Banner updateBanner(int bannerId, Banner banner);

	List<Banner> getAllBanners();
}