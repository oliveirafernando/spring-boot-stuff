package com.oliveirafernando.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Release.class)
public abstract class Release_ {

	public static volatile SingularAttribute<Release, String> note;
	public static volatile SingularAttribute<Release, Person> person;
	public static volatile SingularAttribute<Release, LocalDate> dueDate;
	public static volatile SingularAttribute<Release, String> description;
	public static volatile SingularAttribute<Release, Long> id;
	public static volatile SingularAttribute<Release, LocalDate> paymentDate;
	public static volatile SingularAttribute<Release, ReleaseTypeEnum> type;
	public static volatile SingularAttribute<Release, Category> category;
	public static volatile SingularAttribute<Release, BigDecimal> value;

}

