给定一个 Weather 表，编写一个 SQL 查询，来查找与之前（昨天的）日期相比温度更高的所有日期的 Id。

+---------+------------------+------------------+
| Id(INT) | RecordDate(DATE) | Temperature(INT) |
+---------+------------------+------------------+
|       1 |       2015-01-01 |               10 |
|       2 |       2015-01-02 |               25 |
|       3 |       2015-01-03 |               20 |
|       4 |       2015-01-04 |               30 |
+---------+------------------+------------------+
例如，根据上述给定的 Weather 表格，返回如下 Id:

+----+
| Id |
+----+
|  2 |
|  4 |
+----+

create table Weather_197(
  Id int,
  RecordDate Date,
  Temperature int

);
insert into Weather_197 (Id, RecordDate,Temperature)
values ('1','2015-01-01','10'),('2','2015-01-02','25'),('3','2015-01-03','20'),('4','2015-01-04','30');

select w2.Id from Weather as w1,Weather as w2
where TIMESTAMPDIFF(DAY,w1.RecordDate,w2.RecordDate)=1
and w1.Temperature<w2.Temperature;


#改成自联结
select b.Id from
Weather a inner join Weather b
on TO_DAYS(a.RecordDate) = TO_DAYS(b.RecordDate) - 1
where b.Temperature > a.Temperature;



