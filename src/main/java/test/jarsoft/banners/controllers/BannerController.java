package test.jarsoft.banners.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import test.jarsoft.banners.dto.BannerDto;
import test.jarsoft.banners.services.BannerService;

@RestController
@RequestMapping("/api/banners")
@AllArgsConstructor
public class BannerController {

private final BannerService bannerService;
	
	@GetMapping
	public List<BannerDto> getAllBanners() {
		return bannerService.getAllBanners();
		
	}
	
	@PostMapping("/save")
	public BannerDto createBanner(@RequestBody BannerDto bannerDto) {
		return bannerService.createBanner(bannerDto);
	}
	
	@PutMapping("/delete/{id}")
	public void deleteBanner(@PathVariable("id") int bannerId) {
		bannerService.deleteBanner(bannerId);
	}
	
	@PutMapping("/update/{id}")
	public BannerDto updateBanner(
			@PathVariable("id") int bannerId, 
			@RequestBody BannerDto bannerDto
			) {
		return bannerService.updateBanner(bannerId, bannerDto);
	}
}