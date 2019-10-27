
select stu.number, stu.name, s.subject, s.score
from student as stu
left join score as s
on stu.number = s.number;