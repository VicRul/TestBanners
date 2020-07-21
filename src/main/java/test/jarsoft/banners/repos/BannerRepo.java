package test.jarsoft.banners.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import test.jarsoft.banners.domain.Banner;

public interface BannerRepo extends JpaRepository<Banner, Long> {

}