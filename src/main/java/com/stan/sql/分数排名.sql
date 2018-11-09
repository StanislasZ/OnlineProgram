编写一个 SQL 查询来实现分数排名。如果两个分数相同，则两个分数排名（Rank）相同。
请注意，平分后的下一个名次应该是下一个连续的整数值。换句话说，名次之间不应该有“间隔”。

+----+-------+
| Id | Score |
+----+-------+
| 1  | 3.50  |
| 2  | 3.65  |
| 3  | 4.00  |
| 4  | 3.85  |
| 5  | 4.00  |
| 6  | 3.65  |
+----+-------+
例如，根据上述给定的 Scores 表，你的查询应该返回（按分数从高到低排列）：

+-------+------+
| Score | Rank |
+-------+------+
| 4.00  | 1    |
| 4.00  | 1    |
| 3.85  | 2    |
| 3.65  | 3    |
| 3.65  | 3    |
| 3.50  | 4    |
+-------+------+

select s.Score, (select count(distinct s1.Score) from Scores as s1 where Score>=s.Score) as Rank from Scores as s order by Score desc;

# 外层遍历所有行， 对于特定一行，它的Score作为内层的>=右边的值，内层再次遍历所有行，找到score>=刚才这个特定行的score的行数的count
# 加上distinct ： 内层遍历时， score一样的几行都被认为是一行，去和外层那个score比

select s_out.Score,
       (select count(distinct s_in.Score) from Scores as s_in where s_in.Score>=s_out.Score) as Rank
from Scores as s_out
order by s_out.Score desc;






