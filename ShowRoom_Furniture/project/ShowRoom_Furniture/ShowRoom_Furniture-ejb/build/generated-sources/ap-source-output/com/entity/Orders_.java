package com.entity;

import com.entity.OrderDetails;
import com.entity.Users;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-05-12T07:06:44")
@StaticMetamodel(Orders.class)
public class Orders_ { 

    public static volatile SingularAttribute<Orders, BigDecimal> total;
    public static volatile ListAttribute<Orders, OrderDetails> orderDetailsList;
    public static volatile SingularAttribute<Orders, String> numberPhone;
    public static volatile SingularAttribute<Orders, Integer> id;
    public static volatile SingularAttribute<Orders, Date> orderDate;
    public static volatile SingularAttribute<Orders, Users> userid;
    public static volatile SingularAttribute<Orders, String> shipAddress;
    public static volatile SingularAttribute<Orders, Integer> status;

}