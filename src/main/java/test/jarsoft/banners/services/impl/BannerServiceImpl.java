package test.jarsoft.banners.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import test.jarsoft.banners.domain.Banner;
import test.jarsoft.banners.dto.BannerDto;
import test.jarsoft.banners.dto.DtoConverter;
import test.jarsoft.banners.repos.BannerRepo;
import test.jarsoft.banners.services.BannerService;

@Service
@AllArgsConstructor
public class BannerServiceImpl implements BannerService {

	private final BannerRepo bannerRepo;
	private final DtoConverter dtoConverter;
	
	@Override
	public BannerDto createBanner(BannerDto bannerDto) {
		Banner newBanner = bannerRepo.save(dtoConverter.bannerDtoToBanner(bannerDto));
		return dtoConverter.bannerToBannerDto(newBanner);
	}
	
	@Override
	public void deleteBanner(long bannerId) {
		bannerRepo.deleteBanner(bannerId);
	}
	
	@Override
	public BannerDto updateBanner(int bannerId, BannerDto bannerDto) {
		Banner bannerFromDB = bannerRepo.findById(bannerId);
		Banner banner = dtoConverter.bannerDtoToBanner(bannerDto);
		BeanUtils.copyProperties(banner, bannerFromDB);
		return dtoConverter.bannerToBannerDto(bannerRepo.save(bannerFromDB));
	}

	@Override
	public List<BannerDto> getAllBanners() {
		return bannerRepo.showAllBanners()
				.stream()
				.map(dtoConverter::bannerToBannerDto)
				.collect(Collectors.toList());
	}
}