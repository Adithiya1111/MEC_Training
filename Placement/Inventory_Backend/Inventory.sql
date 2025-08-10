create database inventory;

use inventory;

create table in_management(product_id int auto_increment, product_name varchar(100), product_quantity int, product_price double, primary key (product_id));

select * from in_management;