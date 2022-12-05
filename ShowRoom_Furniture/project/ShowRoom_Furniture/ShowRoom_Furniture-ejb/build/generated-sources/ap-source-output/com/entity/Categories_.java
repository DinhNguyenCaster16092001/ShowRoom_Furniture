package com.entity;

import com.entity.Products;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-05-12T07:06:44")
@StaticMetamodel(Categories.class)
public class Categories_ { 

    public static volatile ListAttribute<Categories, Products> productsList;
    public static volatile SingularAttribute<Categories, String> name;
    public static volatile SingularAttribute<Categories, Integer> id;

}