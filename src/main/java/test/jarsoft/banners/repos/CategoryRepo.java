package test.jarsoft.banners.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import test.jarsoft.banners.domain.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

	@Modifying
	@Query("update Category c set c.deleted = true where c.id = ?1")
	void deleteCategory(int id);
}