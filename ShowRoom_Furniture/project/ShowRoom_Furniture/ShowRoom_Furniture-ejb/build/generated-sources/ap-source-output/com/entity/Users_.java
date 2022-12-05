package com.entity;

import com.entity.Orders;
import com.entity.Roles;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-05-12T07:06:44")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile SingularAttribute<Users, String> firstName;
    public static volatile SingularAttribute<Users, String> lastName;
    public static volatile SingularAttribute<Users, String> password;
    public static volatile ListAttribute<Users, Roles> rolesList;
    public static volatile SingularAttribute<Users, Integer> id;
    public static volatile SingularAttribute<Users, String> email;
    public static volatile ListAttribute<Users, Orders> ordersList;

}