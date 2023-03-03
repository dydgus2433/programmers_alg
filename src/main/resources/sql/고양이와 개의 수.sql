고양이와 개는 몇 마리 있을까
SELECT ANIMAL_TYPE , count(ANIMAL_TYPE) from animal_ins group by animal_type  order by animal_type