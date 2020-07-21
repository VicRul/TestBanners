package test.jarsoft.banners.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import test.jarsoft.banners.domain.Category;

public interface categoryRepo extends JpaRepository<Category, Integer> {

}