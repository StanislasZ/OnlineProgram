
--获取每个顾客的总消费金额
select c.cust_id, sum(oi.quantity * oi.item_price) as total
from customers as c
left join orders as o on c.cust_id = o.cust_id
left join orderitems as oi on o.order_num = oi.order_num
group by c.cust_id;