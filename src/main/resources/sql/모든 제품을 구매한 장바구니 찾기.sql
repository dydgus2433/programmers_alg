
https://school.programmers.co.kr/learn/courses/30/lessons/62284
select distinct A.CART_ID from 
(SELECT CART_ID FROM CART_PRODUCTS
WHERE name = 'Milk') A , (SELECT CART_ID FROM CART_PRODUCTS 
WHERE name = 'Yogurt') B
where A.CART_ID = B.CART_ID 
order by A.CART_ID