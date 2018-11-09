编写一个 SQL 查询，查找所有至少连续出现三次的数字。

+----+-----+
| Id | Num |
+----+-----+
| 1  |  1  |
| 2  |  1  |
| 3  |  1  |
| 4  |  2  |
| 5  |  1  |
| 6  |  2  |
| 7  |  2  |
+----+-----+
例如，给定上面的 Logs 表， 1 是唯一连续出现至少三次的数字。

+-----------------+
| ConsecutiveNums |
+-----------------+
| 1               |
+-----------------+



select distinct(l1.num) as  ConsecutiveNums
from `logs` as l1
inner JOIN `logs` as l2 on l1.Id=l2.Id+1 and l2.num=l1.num
inner join logs as l3 on l1.Id=l3.Id+2 and l1.num=l3.num










