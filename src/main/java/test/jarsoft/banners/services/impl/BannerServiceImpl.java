package test.jarsoft.banners.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import test.jarsoft.banners.domain.Banner;
import test.jarsoft.banners.repos.BannerRepo;
import test.jarsoft.banners.services.BannerService;

@Service
@AllArgsConstructor
public class BannerServiceImpl implements BannerService {

	private final BannerRepo bannerRepo;
	
	@Override
	public Banner createBanner(Banner banner) {
		return bannerRepo.save(banner);
	}
	
	@Override
	public void deleteBanner(int bannerId) {
		bannerRepo.deleteBanner(bannerId);
	}
	
	@Override
	public Banner updateBanner(int bannerId, Banner banner) {
		Banner bannerFromDB = bannerRepo.findById(bannerId);
		BeanUtils.copyProperties(banner, bannerFromDB);
		return bannerRepo.save(bannerFromDB);
	}

	@Override
	public List<Banner> getAllBanners() {
		return bannerRepo.showAllBanners()
				.stream()
				.collect(Collectors.toList());
	}
}