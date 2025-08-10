create database employee;

use employee;

create table Employee(id int auto_increment, name varchar(50) not null, 
salary int not null, dept varchar(50) not null, primary key(id)); 

insert into Employee(id, name, salary, dept) values
(1, 'Venkatesh', 100000, 'BANKING'),  
(2, 'Ragavi', 75000, 'BUSINESS');

drop table Employee;

select * from Employee;
