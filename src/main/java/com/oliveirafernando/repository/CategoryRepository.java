package com.oliveirafernando.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oliveirafernando.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
