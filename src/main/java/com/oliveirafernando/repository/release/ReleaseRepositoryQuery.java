package com.oliveirafernando.repository.release;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.oliveirafernando.model.Release;
import com.oliveirafernando.repository.filter.ReleaseFilter;
import com.oliveirafernando.repository.projection.ReleaseOverview;

public interface ReleaseRepositoryQuery {
	
	public Page<Release> filter(ReleaseFilter releaseFilter, Pageable pageable);
	
	public Page<ReleaseOverview> overview(ReleaseFilter releaseFilter, Pageable pageable);

}
