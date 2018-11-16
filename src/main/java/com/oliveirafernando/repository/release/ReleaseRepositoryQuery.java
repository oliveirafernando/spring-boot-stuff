package com.oliveirafernando.repository.release;

import java.util.List;

import com.oliveirafernando.model.Release;
import com.oliveirafernando.repository.filter.ReleaseFilter;

public interface ReleaseRepositoryQuery {
	
	public List<Release> filter(ReleaseFilter releaseFilter);

}
