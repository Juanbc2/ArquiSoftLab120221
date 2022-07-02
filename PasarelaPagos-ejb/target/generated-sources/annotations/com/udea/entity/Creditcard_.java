package com.udea.entity;

import com.udea.entity.Client;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-07-01T15:39:07")
@StaticMetamodel(Creditcard.class)
public class Creditcard_ { 

    public static volatile SingularAttribute<Creditcard, Integer> cvvCard;
    public static volatile SingularAttribute<Creditcard, String> typeCard;
    public static volatile SingularAttribute<Creditcard, Integer> idClient;
    public static volatile SingularAttribute<Creditcard, Integer> idCard;
    public static volatile SingularAttribute<Creditcard, Client> Client;
    public static volatile SingularAttribute<Creditcard, Date> expirationDate;

}