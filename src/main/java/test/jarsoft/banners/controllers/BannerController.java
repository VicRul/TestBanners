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
import test.jarsoft.banners.domain.Banner;
import test.jarsoft.banners.services.BannerService;

@RestController
@RequestMapping("/api/banners")
@AllArgsConstructor
public class BannerController {

private final BannerService bannerService;
	
	@GetMapping
	public List<Banner> getAllBanners() {
		return bannerService.getAllBanners();
		
	}
	
	@PostMapping("/save")
	public Banner createBanner(@RequestBody Banner banner) {
		return bannerService.createBanner(banner);
	}
	
	@PutMapping("/delete/{id}")
	public void deleteBanner(@PathVariable("id") long bannerId) {
		bannerService.deleteBanner(bannerId);
	}
	
	@PutMapping("/update/{id}")
	public Banner updateBanner(
			@PathVariable("id") long bannerId, 
			@RequestBody Banner banner
			) {
		return bannerService.updateBanner(bannerId, banner);
	}
}