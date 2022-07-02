package com.udea.entity;

import com.udea.entity.Creditcard;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-07-01T15:39:07")
@StaticMetamodel(Transactions.class)
public class Transactions_ { 

    public static volatile SingularAttribute<Transactions, Float> amount;
    public static volatile SingularAttribute<Transactions, Integer> idCard;
    public static volatile SingularAttribute<Transactions, Creditcard> Creditcard;
    public static volatile SingularAttribute<Transactions, Integer> idTransaction;
    public static volatile SingularAttribute<Transactions, Date> timestamp;

}