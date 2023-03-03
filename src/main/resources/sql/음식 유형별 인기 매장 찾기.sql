select a.FOOD_TYPE, A.REST_ID , a.REST_NAME, a.FAVORITES from rest_info  a
,
(SELECT FOOD_TYPE, MAX(FAVORITES) MF from REST_INFO  
group by FOOD_TYPE) b 

where a.favorites = b.mf and a.food_type = b.food_type

order by a.food_type desc