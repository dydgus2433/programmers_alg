https://school.programmers.co.kr/learn/courses/30/lessons/59044
SELECT i.name, i.datetime 
from ANIMAL_INS i 
left join animal_outs o 
on i.animal_id = o.animal_id 
where o.animal_id  is null
order by i.datetime asc limit 3