package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Account.class)
public abstract class Account_ {

	public static volatile SingularAttribute<Account, String> number;
	public static volatile SingularAttribute<Account, String> bank;
	public static volatile SingularAttribute<Account, String> holder;
	public static volatile SingularAttribute<Account, Integer> id;
	public static volatile SingularAttribute<Account, String> office;

}

