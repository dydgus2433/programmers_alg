--https://school.programmers.co.kr/learn/courses/30/lessons/131117

SELECT a.product_id, a.product_name, sum(b.amount)*a.price as total_salse from FOOD_PRODUCT a  -- P0001	맛있는라면	CD_ND00001	면	3780
, FOOD_ORDER b  -- OD00000036	P0071	1200	2022-03-03 00:00:00	2022-03-16 00:00:00	2022-03-16 00:00:00	FT20040002	WH0021
where a.product_id = b.product_id 
and DATE_FORMAT(b.PRODUCE_DATE,'%Y%m') = '202205' 
group by a.product_id, a.product_name
order by total_salse  desc, a.product_id 