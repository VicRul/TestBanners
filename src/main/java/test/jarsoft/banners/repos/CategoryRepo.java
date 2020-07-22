package test.jarsoft.banners.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import test.jarsoft.banners.domain.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

	@Modifying
    @Transactional
	@Query("update Category c set c.deleted = true where c.id = :id")
	void deleteCategory(@Param("id") int id);
	
	Category findById(int id);
	
	@Modifying
	@Query("select c from Category c where c.deleted = false")
	List<Category> showAllCategories();
}