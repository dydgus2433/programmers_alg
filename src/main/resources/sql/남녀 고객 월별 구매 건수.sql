SELECT  b.year YEAR ,b.month MONTH,  a.gender GENDER, count(distinct(a.USER_ID)) USERS from USER_INFO A,  (select year(sales_date) year, month(sales_date) month,user_id from ONLINE_SALE) B
where a.user_id = b.user_id and a.gender is not null
group by year, month, gender
order by year , month, gender, users   