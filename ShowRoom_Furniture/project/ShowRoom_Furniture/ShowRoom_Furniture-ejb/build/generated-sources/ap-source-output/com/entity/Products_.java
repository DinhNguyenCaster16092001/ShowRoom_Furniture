package com.entity;

import com.entity.Brands;
import com.entity.Categories;
import com.entity.OrderDetails;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-05-12T07:06:44")
@StaticMetamodel(Products.class)
public class Products_ { 

    public static volatile SingularAttribute<Products, String> image;
    public static volatile SingularAttribute<Products, Integer> quantity;
    public static volatile SingularAttribute<Products, BigDecimal> price;
    public static volatile ListAttribute<Products, OrderDetails> orderDetailsList;
    public static volatile SingularAttribute<Products, String> substance;
    public static volatile SingularAttribute<Products, Brands> brandid;
    public static volatile SingularAttribute<Products, String> description;
    public static volatile SingularAttribute<Products, String> shortDescription;
    public static volatile SingularAttribute<Products, Integer> id;
    public static volatile SingularAttribute<Products, String> title;
    public static volatile SingularAttribute<Products, Categories> categoryid;
    public static volatile SingularAttribute<Products, Integer> status;

}