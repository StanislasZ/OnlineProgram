Employee 表包含所有员工信息，每个员工有其对应的 Id, salary 和 department Id。
+----+-------+--------+--------------+
| Id | Name  | Salary | DepartmentId |
+----+-------+--------+--------------+
| 1  | Joe   | 70000  | 1            |
| 2  | Henry | 80000  | 2            |
| 3  | Sam   | 60000  | 2            |
| 4  | Max   | 90000  | 1            |
+----+-------+--------+--------------+

Department 表包含公司所有部门的信息。
+----+----------+
| Id | Name     |
+----+----------+
| 1  | IT       |
| 2  | Sales    |
+----+----------+

编写一个 SQL 查询，找出每个部门工资最高的员工。例如，根据上述给定的表格，Max 在 IT 部门有最高工资，Henry 在 Sales 部门有最高工资。
+------------+----------+--------+
| Department | Employee | Salary |
+------------+----------+--------+
| IT         | Max      | 90000  |
| Sales      | Henry    | 80000  |
+------------+----------+--------+



create table Employee_184(
  Id int,
  Name varchar(20),
  Salary int,
  DepartmentId int

);
insert into Employee_184 (Id, Name,Salary,DepartmentId)
values ('1','Joe','70000','1'),('2','Henry','80000','2'),('3','Sam','60000','2'),('4','Max','90000',1);

create table Department_184(
  Id int,
  Name varchar(20)

);
insert into Department_184 (Id, Name)
values ('1','IT'),('2','Sales');




#第一步，  先弄出没最大值的
select d.Name as Department,e.Name as Employee,e.Salary
from Department_184 as d,Employee_184 as e
where e.DepartmentId=d.Id

#第二步， where中加条件，  e.Salary等于 e表中跟他一个部门的所有的人的salary最大值

select d.Name as Department,e.Name as Employee,e.Salary
from Department_184 as d,Employee_184 as e
where e.DepartmentId=d.Id and e.Salary=(Select max(Salary) from Employee_184 where DepartmentId=d.Id);



select d.Name Department,e.Name as Employee,e.Salary as Salary
from Department d inner join Employee e on d.Id = e.DepartmentId
where e.Salary in (select Max(Salary) from Employee where DepartmentId = d.Id)

