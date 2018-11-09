
某网站包含两个表，Customers 表和 Orders 表。编写一个 SQL 查询，找出所有从不订购任何东西的客户。

Customers 表：

+----+-------+
| Id | Name  |
+----+-------+
| 1  | Joe   |
| 2  | Henry |
| 3  | Sam   |
| 4  | Max   |
+----+-------+
Orders 表：

+----+------------+
| Id | CustomerId |
+----+------------+
| 1  | 3          |
| 2  | 1          |
+----+------------+
例如给定上述表格，你的查询应返回：

+-----------+
| Customers |
+-----------+
| Henry     |
| Max       |
+-----------+


create table Customers_183(
  Id int,
  Name varchar(20)

);
insert into Customers_183 (Id, Name)
values ('1','Joe'),('2','Henry'),('3','Sam'),('4','Max');

create table Orders_183(
  Id int,
  CustomerId int
);
insert into Orders_183 (Id, CustomerId)
values ('1','3'),('2','1');

select Name from Customers_183 as c, Orders_183 as o
where c.Id not in (select CustomerId from o);



#思路： 以c的Name为主，去找他的id在o中的CustomerId(不管有没有，都输出结果，没有就是对应Null)
#在结果中，为null的就是要找的
select Name as Customers
from Customers c left join Orders o on c.Id = o.CustomerId
where o.CustomerId is null

