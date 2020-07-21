package test.jarsoft.banners.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import test.jarsoft.banners.domain.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}