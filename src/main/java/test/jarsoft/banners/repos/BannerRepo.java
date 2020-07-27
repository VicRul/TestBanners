package test.jarsoft.banners.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import test.jarsoft.banners.domain.Banner;

public interface BannerRepo extends JpaRepository<Banner, Long> {
	
	@Modifying
    @Transactional
	@Query("update Banner b set b.deleted = true where b.id = :id")
	void deleteBanner(@Param("id") long id);
	
	Banner findById(long id);
	
	@Modifying
	@Query("select b from Banner b where b.deleted = false")
	List<Banner> showAllBanners();
	
	Banner findByName(String name);
}