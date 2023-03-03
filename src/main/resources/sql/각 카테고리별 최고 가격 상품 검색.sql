select b.CATEGORY,	c.price as max_price, b.product_name  from  food_product b , 
(select a.CATEGORY,	max(a.price) as price from food_product a 
where  a.category in ('과자', '국', '김치', '식용유') 
group by a.category) c
where c.price = b.price and c.category = b.category
order by max_price  desc