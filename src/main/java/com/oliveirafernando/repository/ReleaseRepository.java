package com.oliveirafernando.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oliveirafernando.model.Release;

public interface ReleaseRepository extends JpaRepository<Release, Long> {

}
