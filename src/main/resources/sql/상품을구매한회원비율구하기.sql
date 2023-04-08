-- 코드를 입력하세요
SELECT * from  USER_INFO A, -- 1	1	25	2021-06-03 00:00:00
ONLINE_SALE B--online_sale_id	user_id	product_id	sales_amount	sales_date 
-- 1	2	26	1	2022-01-01 00:00:00

select user_id from online_sale group by user_id;
--SELECT count(*)  from  USER_INFO A where TO_CHAR(JOINED,'YYYY') = '2021'



select count(*) from user_info where user_id in (select user_id from online_sale where TO_CHAR(SALES_DATE,'YYYYMM') = '2022' group by user_id )


select '2021'||LPAD(LEVEL,2,0) AS NO
FROM DUAL CONNECT BY LEVEL <= 12


SELECT b.year , b.no,    count(distinct a.user_id) from year_month B,  USER_INFO A 
where B.YEAR||B.no = TO_CHAR(JOINED,'YYYYMM') group by b.year , b.no



SELECT b.year , b.no,    count(distinct a.user_id) from year_month B,  ONLINE_SALE  A 
where B.YEAR||B.no = TO_CHAR(SALES_DATE,'YYYYMM') group by b.year , b.no

------------

with  year_month AS
 (
select 2022 as YEAR ,LPAD(LEVEL,2,0) AS NO
FROM DUAL CONNECT BY LEVEL <= 12
) 

select a.year, a.no , a.count as PUCHASED_USERS, a.count / b.count as PUCHASED_RATIO

from 
(SELECT b.year , b.no, count(distinct a.user_id) count from year_month B,  USER_INFO  A 
where B.YEAR||B.no = TO_CHAR(JOINED,'YYYYMM') group by b.year , b.no
) a , 
(SELECT b.year , b.no, count(distinct a.user_id) count from year_month B,  ONLINE_SALE  A 
where B.YEAR||B.no = TO_CHAR(SALES_DATE,'YYYYMM') group by b.year , b.no
) b
where a.year = b.year and a.no = b.no

----

with  year_month AS
 (
select 2022 as YEAR ,LPAD(LEVEL,2,0) AS NO
FROM DUAL CONNECT BY LEVEL <= 12
),
tot_count as (
    SELECT count(distinct user_id) as cnt from  USER_INFO  A 
where  TO_CHAR(JOINED,'YYYY') = '2021' )

select a.year, a.no , a.count as PUCHASED_USERS, round(a.count/tot_count.cnt,1)
as PUCHASED_RATIO
from 
(SELECT b.year , b.no, count(distinct a.user_id) count from year_month B,  ONLINE_SALE  A 
where B.YEAR||B.no = TO_CHAR(SALES_DATE,'YYYYMM') group by b.year , b.no
) a
order by a.year , a.no



 ---
with  year_month AS
 (
select 2022 as YEAR ,LPAD(LEVEL,2,0) AS month
FROM DUAL CONNECT BY LEVEL <= 12
),
tot_count as (
    SELECT count(distinct user_id) as cnt from  USER_INFO  A 
where  TO_CHAR(JOINED,'YYYY') = '2021' )

select a.year, a.month  , a.count as PUCHASED_USERS, round(a.count/b.cnt,1)
as PUCHASED_RATIO
from 
(SELECT b.year , b.month, count(distinct a.user_id) count from year_month B,  ONLINE_SALE  A , USER_INFO C
where B.YEAR||B.month = TO_CHAR(SALES_DATE,'YYYYMM')
 and a.user_id = c.user_id
 group by b.year , b.month
) a , tot_count b
order by a.year , a.month
