package com.oliveirafernando.repository.release;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;

import com.oliveirafernando.model.Release;
import com.oliveirafernando.model.Release_;
import com.oliveirafernando.repository.filter.ReleaseFilter;

public class ReleaseRepositoryImpl implements ReleaseRepositoryQuery {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Release> filter(ReleaseFilter releaseFilter) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Release> criteria = builder.createQuery(Release.class);
		Root<Release> root = criteria.from(Release.class);

		Predicate[] predicates = createPredicates(releaseFilter, builder, root);
		criteria.where(predicates);

		TypedQuery<Release> query = entityManager.createQuery(criteria);
		return query.getResultList();
	}

	private Predicate[] createPredicates(ReleaseFilter releaseFilter, CriteriaBuilder builder, Root<Release> root) {

		List<Predicate>  predicates = new LinkedList<Predicate>();
		
		if (!StringUtils.isEmpty(releaseFilter.getDescription())) {
			predicates.add(builder.like(
					builder.lower(root.get(Release_.description)), "%" + releaseFilter.getDescription().toLowerCase() + "%"));
		}

		if (releaseFilter.getDueDateFrom() != null) {
			predicates.add(builder.greaterThanOrEqualTo(root.get(Release_.dueDate), releaseFilter.getDueDateFrom()));
		}

		if (releaseFilter.getDueDateTo() != null) {
			predicates.add(builder.lessThanOrEqualTo(root.get(Release_.dueDate), releaseFilter.getDueDateTo()));
		}

		return predicates.toArray(new Predicate[predicates.size()]);
	}

}
