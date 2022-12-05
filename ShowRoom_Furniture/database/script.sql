CREATE DATABASE ShowRoom_Furniture

USE ShowRoom_Furniture

CREATE TABLE brands (
  id   int IDENTITY NOT NULL, 
  name nvarchar(225) NULL UNIQUE, 
  PRIMARY KEY (id));


CREATE TABLE categories (
  id   int IDENTITY NOT NULL, 
  name nvarchar(225) NULL UNIQUE, 
  PRIMARY KEY (id));


CREATE TABLE orders (
  id           int IDENTITY NOT NULL, 
  total        decimal(10, 3) NULL, 
  order_date   datetime NULL DEFAULT CURRENT_TIMESTAMP , 
  ship_address nvarchar(225) NULL, 
  status       int NULL, 
  number_phone nvarchar(10) NOT NULL, 
  userid       int NOT NULL, 
  PRIMARY KEY (id));

CREATE TABLE order_details (
  orderid   int NOT NULL, 
  productid int NOT NULL, 
  quantity  int NULL, 
  PRIMARY KEY (orderid, 
  productid));
CREATE TABLE products (
  id                int IDENTITY NOT NULL, 
  title             nvarchar(225) NULL, 
  price             decimal(10, 3) NULL DEFAULT 0, 
  quantity          int NOT NULL, 
  short_description nvarchar(225) NOT NULL, 
  description       text NOT NULL, 
  status            int NULL, 
  image             nvarchar(225) NULL, 
  substance         nvarchar(225) NULL, 
  categoryid        int NOT NULL, 
  brandid           int NOT NULL, 
  PRIMARY KEY (id));


CREATE TABLE roles (
  id    int IDENTITY NOT NULL, 
  title nvarchar(225) NULL, 
  PRIMARY KEY (id));

CREATE TABLE roles_users (
  roleid int NOT NULL, 
  userid int NOT NULL, 
  PRIMARY KEY (roleid, 
  userid));


CREATE TABLE users (
  id         int IDENTITY NOT NULL, 
  first_name nvarchar(225) NOT NULL, 
  last_name  nvarchar(225) NULL, 
  email      nvarchar(225) NULL UNIQUE, 
  password   nvarchar(300) NULL, 
  PRIMARY KEY (id));


ALTER TABLE products ADD CONSTRAINT FKproduct573550 FOREIGN KEY (categoryid) REFERENCES categories (id);
ALTER TABLE products ADD CONSTRAINT FKproduct744090 FOREIGN KEY (brandid) REFERENCES brands (id);
ALTER TABLE orders ADD CONSTRAINT FKorder421628 FOREIGN KEY (userid) REFERENCES users (id);
ALTER TABLE order_details ADD CONSTRAINT FKorder_deta471234 FOREIGN KEY (orderid) REFERENCES orders (id);
ALTER TABLE order_details ADD CONSTRAINT FKorder_deta672196 FOREIGN KEY (productid) REFERENCES products (id);
ALTER TABLE roles_users ADD CONSTRAINT FKrole_user838259 FOREIGN KEY (roleid) REFERENCES roles (id);
ALTER TABLE roles_users ADD CONSTRAINT FKrole_user359664 FOREIGN KEY (userid) REFERENCES users (id);
