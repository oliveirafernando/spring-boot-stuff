package com.oliveirafernando.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oliveirafernando.model.Release;
import com.oliveirafernando.repository.release.ReleaseRepositoryQuery;

public interface ReleaseRepository extends JpaRepository<Release, Long>, ReleaseRepositoryQuery {

}
