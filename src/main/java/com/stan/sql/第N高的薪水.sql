编写一个 SQL 查询，获取 Employee 表中第 n 高的薪水（Salary）。

+----+--------+
| Id | Salary |
+----+--------+
| 1  | 100    |
| 2  | 200    |
| 3  | 300    |
+----+--------+
例如上述 Employee 表，n = 2 时，应返回第二高的薪水 200。如果不存在第 n 高的薪水，那么查询应返回 null。

+------------------------+
| getNthHighestSalary(2) |
+------------------------+
| 200                    |
+------------------------+


CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
    Declare M int;
    Set M = N-1;
  RETURN (

      select IFNULL((select distinct Salary from Employee order by Salary DESC limit M,1),NULL) AS getNthHighestSalary
  );
END