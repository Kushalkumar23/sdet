REM   Script: Activity 9
REM   Activity 9

create table orders( 
    order_no int primary key, purchase_amount float, order_date date, 
    customer_id int, salesman_id int);

INSERT ALL 
    INTO orders VALUES(70001, 150.5, TO_DATE('2012/10/05', 'YYYY/MM/DD'), 3005, 5002)  
    INTO orders VALUES(70009, 270.65, TO_DATE('2012/09/10', 'YYYY/MM/DD'), 3001, 5005) 
    INTO orders VALUES(70002, 65.26, TO_DATE('2012/10/05', 'YYYY/MM/DD'), 3002, 5001) 
    INTO orders VALUES(70004, 110.5, TO_DATE('2012/08/17', 'YYYY/MM/DD'), 3009, 5003) 
    INTO orders VALUES(70007, 948.5, TO_DATE('2012/09/10', 'YYYY/MM/DD'), 3005, 5002) 
    INTO orders VALUES(70005, 2400.6, TO_DATE('2012/07/27', 'YYYY/MM/DD'), 3007, 5001) 
    INTO orders VALUES(70008, 5760, TO_DATE('2012/08/15', 'YYYY/MM/DD'), 3002, 5001) 
    INTO orders VALUES(70010, 1983.43, TO_DATE('2012/10/10', 'YYYY/MM/DD'), 3004, 5006) 
    INTO orders VALUES(70003, 2480.4, TO_DATE('2012/10/10', 'YYYY/MM/DD'), 3009, 5003) 
    INTO orders VALUES(70012, 250.45, TO_DATE('2012/06/27', 'YYYY/MM/DD'), 3008, 5002) 
    INTO orders VALUES(70011, 75.29, TO_DATE('2012/08/17', 'YYYY/MM/DD'), 3003, 5007) 
    INTO orders VALUES(70013, 3045.6, TO_DATE('2012/04/25', 'YYYY/MM/DD'), 3002, 5001) 
SELECT 1 FROM DUAL;

select * from employees;

select * from orders;

select order_no, sum(purchase_amount) from orders group by order_no;

select order_no, avg(purchase_amount) from orders group by order_no;

select order_no, avg(purchase_amount) from orders group by order_no;

select order_no, avg(purchase_amount) from orders group by order_no order by order_no;

select order_no, sum(purchase_amount) from orders group by order_no order by order_no;

select order_no, avg(purchase_amount) from orders group by order_no order by order_no;

select order_no, avg(purchase_amount) from orders group by order_no order by order_no;

select order_no, sum(purchase_amount) from orders group by order_no order by order_no;

select order_no, avg(purchase_amount) from orders group by order_no order by order_no;

select sum(purchase_amount) from orders;

select avg(purchase_amount) from orders;

select max(purchase_amount) from orders;

select min(purchase_amount) from orders;

select * from orders;

select count(unique(salseman_id)) from orders;

select count(unique(salesman_id)) from orders;

select count(distinct (salesman_id)) from orders;

select * from orders;

select * from orders;

select * from orders order by customer_id;

select order_id, max(purchase_amount) from orders group by customer_id order by customer_id;

select * from orders;

select customer_id, max(purchase_amount) from orders group by customer_id order by customer_id;

select * from orders;

select * from orders where order_date is "17-Sep-2012";

create table orders( 
    order_no int primary key, purchase_amount float, order_date date, 
    customer_id int, salesman_id int);

INSERT ALL 
    INTO orders VALUES(70001, 150.5, TO_DATE('2012/10/05', 'YYYY/MM/DD'), 3005, 5002)  
    INTO orders VALUES(70009, 270.65, TO_DATE('2012/09/10', 'YYYY/MM/DD'), 3001, 5005) 
    INTO orders VALUES(70002, 65.26, TO_DATE('2012/10/05', 'YYYY/MM/DD'), 3002, 5001) 
    INTO orders VALUES(70004, 110.5, TO_DATE('2012/08/17', 'YYYY/MM/DD'), 3009, 5003) 
    INTO orders VALUES(70007, 948.5, TO_DATE('2012/09/10', 'YYYY/MM/DD'), 3005, 5002) 
    INTO orders VALUES(70005, 2400.6, TO_DATE('2012/07/27', 'YYYY/MM/DD'), 3007, 5001) 
    INTO orders VALUES(70008, 5760, TO_DATE('2012/08/15', 'YYYY/MM/DD'), 3002, 5001) 
    INTO orders VALUES(70010, 1983.43, TO_DATE('2012/10/10', 'YYYY/MM/DD'), 3004, 5006) 
    INTO orders VALUES(70003, 2480.4, TO_DATE('2012/10/10', 'YYYY/MM/DD'), 3009, 5003) 
    INTO orders VALUES(70012, 250.45, TO_DATE('2012/06/27', 'YYYY/MM/DD'), 3008, 5002) 
    INTO orders VALUES(70011, 75.29, TO_DATE('2012/08/17', 'YYYY/MM/DD'), 3003, 5007) 
    INTO orders VALUES(70013, 3045.6, TO_DATE('2012/04/25', 'YYYY/MM/DD'), 3002, 5001) 
SELECT 1 FROM DUAL;

select * from orders 
 
--SQL statement to find the highest purchase amount ordered by the each customer with their ID and highest purchase amount 
select customer_id, max(purchase_amount) from orders group by customer_id order by customer_id 
 
--SQL statement to find the highest purchase amount on '2012-08-17' for each salesman with their ID. 
select * from orders where order_date is "2012-08-17" 
;

select * from orders where order_date is "2012-08-17";

select * from orders where order_date = to_date('2012/08/17',yyyy/mm/dd);

select * from orders where order_date = to_date('2012/08/17','yyyy/mm/dd');

select salesman_id, max(purchase_amount) from orders where order_date = to_date('2012/08/17','yyyy/mm/dd') order by salesman_id;

select salesman_id, max(purchase_amount) from orders where order_date = to_date('2012/08/17','yyyy/mm/dd') group by salesman_id;

select salesman_id, max(purchase_amount) from orders where order_date = to_date('2012/08/17','yyyy/mm/dd') group by salesman_id,order_date;

select * from orders;

select order_id, max(purchase_Amount) from orders group by order_id;

select * from orders;

select order_id, max(purchase_Amount) from orders group by order_no;

select order_no, max(purchase_Amount) from orders group by order_no;

select customer_id, max(purchase_Amount) from orders group by customer_id;

select customer_id,order_date, purchase_Amount from orders group by customer_id,order_date 
having max(purchase_Amount) in (2030, 3450, 5760, 6000) 
;

create table orders( 
    order_no int primary key, purchase_amount float, order_date date, 
    customer_id int, salesman_id int);

INSERT ALL 
    INTO orders VALUES(70001, 150.5, TO_DATE('2012/10/05', 'YYYY/MM/DD'), 3005, 5002)  
    INTO orders VALUES(70009, 270.65, TO_DATE('2012/09/10', 'YYYY/MM/DD'), 3001, 5005) 
    INTO orders VALUES(70002, 65.26, TO_DATE('2012/10/05', 'YYYY/MM/DD'), 3002, 5001) 
    INTO orders VALUES(70004, 110.5, TO_DATE('2012/08/17', 'YYYY/MM/DD'), 3009, 5003) 
    INTO orders VALUES(70007, 948.5, TO_DATE('2012/09/10', 'YYYY/MM/DD'), 3005, 5002) 
    INTO orders VALUES(70005, 2400.6, TO_DATE('2012/07/27', 'YYYY/MM/DD'), 3007, 5001) 
    INTO orders VALUES(70008, 5760, TO_DATE('2012/08/15', 'YYYY/MM/DD'), 3002, 5001) 
    INTO orders VALUES(70010, 1983.43, TO_DATE('2012/10/10', 'YYYY/MM/DD'), 3004, 5006) 
    INTO orders VALUES(70003, 2480.4, TO_DATE('2012/10/10', 'YYYY/MM/DD'), 3009, 5003) 
    INTO orders VALUES(70012, 250.45, TO_DATE('2012/06/27', 'YYYY/MM/DD'), 3008, 5002) 
    INTO orders VALUES(70011, 75.29, TO_DATE('2012/08/17', 'YYYY/MM/DD'), 3003, 5007) 
    INTO orders VALUES(70013, 3045.6, TO_DATE('2012/04/25', 'YYYY/MM/DD'), 3002, 5001) 
SELECT 1 FROM DUAL;

select * from orders 
 
--SQL statement to find the highest purchase amount ordered by the each customer with their ID and highest purchase amount 
select customer_id, max(purchase_amount) from orders group by customer_id order by customer_id 
 
--SQL statement to find the highest purchase amount on '2012-08-17' for each salesman with their ID. 
select salesman_id, max(purchase_amount) from orders where order_date = to_date('2012/08/17','yyyy/mm/dd') group by salesman_id,order_date 
 
--SQL statement to find the highest purchase amount with their ID and order date, for only those customers who have a higher purchase amount within the list [2030, 3450, 5760, 6000]. 
select customer_id,order_date, max(purchase_Amount) from orders group by customer_id,order_date 
having max(purchase_Amount) in (2030, 3450, 5760, 6000) 
;

select customer_id,order_date, max(purchase_Amount) from orders group by customer_id,order_date 
having max(purchase_Amount) in (2030, 3450, 5760, 6000);

create table customers ( 
    customer_id int primary key, customer_name varchar(32), 
    city varchar(20), grade int, salesman_id int);

insert into customers values  
(3002, 'Nick Rimando', 'New York', 100, 5001), (3007, 'Brad Davis', 'New York', 200, 5001), 
(3005, 'Graham Zusi', 'California', 200, 5002), (3008, 'Julian Green', 'London', 300, 5002), 
(3004, 'Fabian Johnson', 'Paris', 300, 5006), (3009, 'Geoff Cameron', 'Berlin', 100, 5003), 
(3003, 'Jozy Altidor', 'Moscow', 200, 5007), (3001, 'Brad Guzan', 'London', 300, 5005);

insert into customers values  
(3002, 'Nick Rimando', 'New York', 100, 5001), (3007, 'Brad Davis', 'New York', 200, 5001), 
(3005, 'Graham Zusi', 'California', 200, 5002), (3008, 'Julian Green', 'London', 300, 5002), 
(3004, 'Fabian Johnson', 'Paris', 300, 5006), (3009, 'Geoff Cameron', 'Berlin', 100, 5003), 
(3003, 'Jozy Altidor', 'Moscow', 200, 5007), (3001, 'Brad Guzan', 'London', 300, 5005);

SELECT 1 FROM DUAL;

insert all  
into customers values (3002, 'Nick Rimando', 'New York', 100, 5001),  
INTO customers VALUES(3007, 'Brad Davis', 'New York', 200, 5001), 
INTO customers VALUES(3005, 'Graham Zusi', 'California', 200, 5002), 
INTO customers VALUES(3008, 'Julian Green', 'London', 300, 5002), 
INTO customers VALUES(3004, 'Fabian Johnson', 'Paris', 300, 5006), 
INTO customers VALUES(3009, 'Geoff Cameron', 'Berlin', 100, 5003), 
INTO customers VALUES(3003, 'Jozy Altidor', 'Moscow', 200, 5007),  
INTO customers VALUES(3001, 'Brad Guzan', 'London', 300, 5005);

SELECT 1 FROM DUAL;

insert all  
into customers values (3002, 'Nick Rimando', 'New York', 100, 5001),  
INTO customers VALUES(3007, 'Brad Davis', 'New York', 200, 5001), 
INTO customers VALUES(3005, 'Graham Zusi', 'California', 200, 5002), 
INTO customers VALUES(3008, 'Julian Green', 'London', 300, 5002), 
INTO customers VALUES(3004, 'Fabian Johnson', 'Paris', 300, 5006), 
INTO customers VALUES(3009, 'Geoff Cameron', 'Berlin', 100, 5003), 
INTO customers VALUES(3003, 'Jozy Altidor', 'Moscow', 200, 5007), 
INTO customers VALUES(3001, 'Brad Guzan', 'London', 300, 5005) 
SELECT 1 FROM DUAL;

insert all  
into customers values (3002, 'Nick Rimando', 'New York', 100, 5001),  
INTO customers VALUES(3007, 'Brad Davis', 'New York', 200, 5001), 
INTO customers VALUES(3005, 'Graham Zusi', 'California', 200, 5002), 
INTO customers VALUES(3008, 'Julian Green', 'London', 300, 5002), 
INTO customers VALUES(3004, 'Fabian Johnson', 'Paris', 300, 5006), 
INTO customers VALUES(3009, 'Geoff Cameron', 'Berlin', 100, 5003), 
INTO customers VALUES(3003, 'Jozy Altidor', 'Moscow', 200, 5007), 
INTO customers VALUES(3001, 'Brad Guzan', 'London', 300, 5005) 
SELECT 1 FROM DUAL;

insert all  
into customers values (3002, 'Nick Rimando', 'New York', 100, 5001) 
INTO customers VALUES(3007, 'Brad Davis', 'New York', 200, 5001) 
INTO customers VALUES(3005, 'Graham Zusi', 'California', 200, 5002) 
INTO customers VALUES(3008, 'Julian Green', 'London', 300, 5002) 
INTO customers VALUES(3004, 'Fabian Johnson', 'Paris', 300, 5006) 
INTO customers VALUES(3009, 'Geoff Cameron', 'Berlin', 100, 5003) 
INTO customers VALUES(3003, 'Jozy Altidor', 'Moscow', 200, 5007) 
INTO customers VALUES(3001, 'Brad Guzan', 'London', 300, 5005);

insert all  
(3002, 'Nick Rimando', 'New York', 100, 5001) 
INTO customers VALUES(3007, 'Brad Davis', 'New York', 200, 5001) 
INTO customers VALUES(3005, 'Graham Zusi', 'California', 200, 5002) 
INTO customers VALUES(3008, 'Julian Green', 'London', 300, 5002) 
INTO customers VALUES(3004, 'Fabian Johnson', 'Paris', 300, 5006) 
INTO customers VALUES(3009, 'Geoff Cameron', 'Berlin', 100, 5003) 
INTO customers VALUES(3003, 'Jozy Altidor', 'Moscow', 200, 5007) 
INTO customers VALUES(3001, 'Brad Guzan', 'London', 300, 5005) 
SELECT 1 FROM DUAL;

insert all  
(3002, 'Nick Rimando', 'New York', 100, 5001);

insert INTO customers VALUES(3002, 'Nick Rimando', 'New York', 100, 5001);

insert INTO customers VALUES(3007, 'Brad Davis', 'New York', 200, 5001);

insert INTO customers VALUES(3005, 'Graham Zusi', 'California', 200, 5002);

insert INTO customers VALUES(3008, 'Julian Green', 'London', 300, 5002);

insert INTO customers VALUES(3004, 'Fabian Johnson', 'Paris', 300, 5006);

insert INTO customers VALUES(3009, 'Geoff Cameron', 'Berlin', 100, 5003);

insert INTO customers VALUES(3003, 'Jozy Altidor', 'Moscow', 200, 5007);

insert INTO customers VALUES(3001, 'Brad Guzan', 'London', 300, 5005);

select * from customers;

select * from orders;

select  *from customers;

select * from orders;

select  *from customers;

