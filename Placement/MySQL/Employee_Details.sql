create database employee_details;

use employee_details;

create table Employee(EMPLOYEE_ID int, FIRST_NAME varchar(50), LAST_NAME varchar(20), 
SALARY int, JOINING_DATE varchar(20), DEPARTMENT varchar(50), primary key(EMPLOYEE_ID)); 

insert into Employee(EMPLOYEE_ID, FIRST_NAME, LAST_NAME, SALARY, JOINING_DATE, DEPARTMENT) values
(1, 'Venkatesh', 'S', 100000, '08/28/2015', 'BANKING'),  
(2, 'Ragavi', 'P', 75000, '08/28/2015', 'BUSINESS'),
(3, 'Gopinath', 'C', 50000, '03/02/2016', 'PHARMA'),
(4, 'Dinesh', 'G', 50000, '03/02/2016', 'INSURANCE'),
(5, 'Saibabu', 'E', 40000, '07/08/2017', 'SOFTWARE'),
(6, 'Hasan', 'S', 29000, '07/08/2017', 'MANUFACTURING'),
(7, 'Divya', 'P', 33000, '07/08/2017', 'HEALTHCARE'),
(8, 'Aravindan', 'R', 40000, '07/08/2017', 'HEALTHCARE'),
(9, 'Sathish', 'MD', 45000, '03/02/2016', 'AUTOMOBILE'),
(10, 'Prasanth', 'PKP', 34000, '03/02/2016', 'INSURANCE'),
(11, 'Vijay', 'R', 25684, '03/02/2016', 'BUSINESS'),
(12, 'Sivakumar', 'K', 54789, '03/02/2016', 'SOFTWARE');

drop table Employee;

select * from Employee;

create table Employee_Incentive(EMPLOYEE_REF_ID int, INCENTIVE_DATE varchar(20), 
INCENTIVE_AMOUNT int, foreign key(EMPLOYEE_REF_ID) references Employee(EMPLOYEE_ID));

insert into Employee_Incentive(EMPLOYEE_REF_ID, INCENTIVE_DATE, INCENTIVE_AMOUNT) values
(1, '01-FEB-16', 5000),
(2, '01-FEB-16', 3000),
(3, '01-FEB-17', 4000),
(1, '01-JAN-17', 4500),
(2, '01-JAN-17', 3500);

drop table Employee_Incentive;

select * from Employee_Incentive;

show tables;

select * from Employee e join Employee_Incentive ei on e.EMPLOYEE_ID = ei.EMPLOYEE_REF_ID;

-- 1) Get all employee details from the employee table.
select * from Employee;

-- 2) Get First_Name, Last_Name from employee table.
select FIRST_NAME, LAST_NAME from Employee;

-- 3) Get First_Name from employee table using alias name "Employee Name".
select FIRST_NAME as Employee_Name from Employee;

-- 4) Get First_Name from employee table in Upper Case.
select upper(FIRST_NAME) from Employee;

-- 5) Get First_Name from employee table in Lower Case.
select lower(FIRST_NAME) from Employee;

-- 6) Get unique DEPARTMENT from employee table.
select distinct DEPARTMENT from Employee;

-- 7) Select first 3 characters of First_Name from Employee.
select substring(FIRST_NAME, 1, 3) from Employee;

-- 8) Get position of 'a' in name 'ragavi' from employee table.
select position('a' in 'ragavi');

-- 9) Get First_Name from employee table after removing white spaces from right side.
select rtrim(FIRST_NAME) from Employee;

-- 10) Get First_Name from employee table after removing white spaces from left side.
select ltrim(FIRST_NAME) from Employee;

-- 11) Get length of First_Name from employee table;
select length(FIRST_NAME) from Employee;

-- 12) Get First_Name from employee table after replacing 'a' with '$'.
select replace(FIRST_NAME, 'a', '$') from Employee;

-- 13) Get First_Name and Last_Name as single column from employee table separated by a'_'.
select concat(FIRST_NAME, '_', LAST_NAME) as Employee_Name from Employee;
  
-- 14) Get First_Name, Joining_Year, Joining_Month, Joining_Date from employee table.
 select FIRST_NAME, substring(JOINING_DATE, 7, 4) as JOINING_YEAR, substring(JOINING_DATE, 4, 2) as JOINING_MONTH,
 substring(JOINING_DATE, 1, 2) as JOINING_DATE from Employee;
 
 -- 15) Get all employee details from the employee table order by First_Name ascending.
 select FIRST_NAME from Employee order by FIRST_NAME asc;
 
-- 16) Get all employee details from the employee table order by First_Name descending.
 select FIRST_NAME from Employee order by FIRST_NAME desc;
 
 -- 17) Get all employee details from the employee table order by First_Name descending and Salary descending.
 select * from Employee order by FIRST_NAME asc, SALARY desc;
 
 -- 18) Get employee details from employee table whose employee name is "Dinesh".
 select * from Employee where FIRST_NAME ='Dinesh';
 
-- 19) Get employee details from employee table whose employee name are "Dinesh" and "Roy".
 select * from Employee where FIRST_NAME in ('Dinesh', 'Roy'); -- null value because it does not satisfy the condition
 
-- 20) Get employee details from employee table whose employee name are not "Dinesh" and "Roy".
 select * from Employee where not FIRST_NAME in ('Dinesh', 'Roy');
 
-- 21) Get employee details from employee table whose First_Name starts with 's'.
 select * from Employee where FIRST_NAME like 's%'; 
 
-- 22) Get employee details from employee table whose First_Name contains with 'v'.
 select * from Employee where FIRST_NAME like '%v%'; 
 
-- 23) Get employee details from employee table whose First_Name ends with 'n' and name contains 4 letters.
 select * from Employee where FIRST_NAME like '%n' and '%____%'; 
 
-- 24) Get employee details from employee table whose First_Name starts with 'J' and name contains 4 letters.
 select * from Employee where FIRST_NAME like 'J%' and '%____%'; 
 
-- 25) Get employee details from employee table who's salary is greater than 60000.
 select * from Employee where SALARY > 60000; 
 
-- 26) Get employee details from employee table who's salary is less than 80000.
 select * from Employee where SALARY < 80000; 
 
-- 27) Get employee details from employee table who's salary is between 50000 and 80000.
 select * from Employee where SALARY between 50000 and 80000; 
 
-- 28) Get employee details from employee table whose name is 'Venkatesh' and 'Ragavi'.
 select * from Employee where FIRST_NAME in ('Venkatesh', 'Ragavi'); 
 
-- 29) Get names of employees from employee table who has '%' in Last_Name.
 select FIRST_NAME from Employee where LAST_NAME like '%';
 
-- 30) Get Last_Name from employee table after replacing special character with white space.
 select replace(LAST_NAME, ' ', '$')  as LAST_NAME from Employee;
 
-- 31) Get department, total salary with respect to a department from employee table.
select DEPARTMENT, sum(SALARY) from Employee group by DEPARTMENT;

-- 32) Get department, total salary with respect to a department from employee table order by total salary descending.
select sum(SALARY), DEPARTMENT, count(SALARY) from Employee group by DEPARTMENT order by count(SALARY) desc;

-- 33) Get department, no. of employees in a department, total salary with respect to a department from employee table order by total salary descending.   
 select DEPARTMENT, count(EMPLOYEE_ID), sum(SALARY) as SALARY_Desc, count(SALARY) from Employee group by DEPARTMENT order by count(SALARY) desc;
 
-- 34) Get department wise average salary from employee table order by salary ascending.
select DEPARTMENT, avg(SALARY), count(SALARY) from Employee group by DEPARTMENT order by count(SALARY) asc;

-- 35) Get department wise maximum salary from employee table order by salary ascending.
select DEPARTMENT, max(SALARY), count(SALARY) from Employee group by DEPARTMENT order by count(SALARY) asc; 

-- 36) Get department wise minimum salary from employee table order by salary ascending.
select DEPARTMENT, min(SALARY), count(SALARY) from Employee group by DEPARTMENT order by count(SALARY) asc;

-- 37) Select no. of employees joined with respect to year and month from employee table.
select substring(JOINING_DATE, 7, 4) as Join_Year, substring(JOINING_DATE, 1, 2) as Join_Month, count(*) as No_Of_Employee from Employee group by JOINING_DATE;

-- 38) Select department, total salary with respect to a department from employee table where total salary is greater than 800000 by total_salary descending.
select DEPARTMENT, sum(SALARY), count(SALARY) from Employee where SALARY < 800000 group by DEPARTMENT order by count(SALARY) desc;

-- 39) Select First_Name, Incentive_Amount from employee and incentive table for those employees who have incentives.
select FIRST_NAME, INCENTIVE_AMOUNT from Employee e join Employee_Incentive ei on e.EMPLOYEE_ID = ei.EMPLOYEE_REF_ID;

-- 40) Select First_Name, Incentive_Amount from employee and incentive table for those employees who have incentives and incentive greater than 3000.
select FIRST_NAME, INCENTIVE_AMOUNT from Employee e join Employee_Incentive ei on e.EMPLOYEE_ID = ei.EMPLOYEE_REF_ID where INCENTIVE_AMOUNT > 3000;  

-- 41) Select First_Name, Incentive_Amount from employee and incentive table for those employees even if they didn't get incentives.
select FIRST_NAME, INCENTIVE_AMOUNT from Employee e left join Employee_Incentive ei on e.EMPLOYEE_ID = ei.EMPLOYEE_REF_ID;

-- 42) Select First_Name, Incentive_Amount from employee and incentive table for those employees even if they didn't get incentives, 
-- change the incentive amount as 0 for those employees who didn't get incentives.
select FIRST_NAME, coalesce(INCENTIVE_AMOUNT, 0) as INCENTIVE_AMOUNT from Employee e left join Employee_Incentive ei on e.EMPLOYEE_ID = ei.EMPLOYEE_REF_ID;

-- 43) Select First_Name, Incentive_Amount from employee and incentive table for those employees using left join.
select FIRST_NAME, INCENTIVE_AMOUNT from Employee e left join Employee_Incentive ei on e.EMPLOYEE_ID = ei.EMPLOYEE_REF_ID;

-- 44) Select max incentive with respect to employee from employees and incentives table using sub query.
select e.FIRST_NAME, (select max(INCENTIVE_AMOUNT) from Employee_Incentive ei where ei.EMPLOYEE_REF_ID = e.EMPLOYEE_ID) as Max_Incentive from Employee e;

-- 45) Select top 2 salary from employee table.
select SALARY from Employee order by SALARY desc limit 2;

-- 46) Select top N salary from employee table.
select SALARY from Employee order by SALARY desc limit n ;

-- 47) Select 2nd Highest salary from employee table.
select distinct SALARY from Employee order by SALARY desc limit 1 offset 1;	

-- 48) Select Nth Highest salary from employee table.
select distinct SALARY from Employee order by SALARY desc limit n offset n;	

SELECT @@autocommit;
