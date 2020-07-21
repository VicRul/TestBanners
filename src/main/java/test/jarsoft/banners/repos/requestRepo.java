package test.jarsoft.banners.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import test.jarsoft.banners.domain.Request;

public interface requestRepo extends JpaRepository<Request, Long> {

}