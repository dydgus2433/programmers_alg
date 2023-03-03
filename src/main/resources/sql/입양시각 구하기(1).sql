select * from (
SELECT AI.ANIMAL_ID,	AI.NAME 
FROM ANIMAL_INS AI inner join ANIMAL_OUTS AO 
on AI.ANIMAL_ID = AO.ANIMAL_ID
order by AO.DATETIME - AI.DATETIME desc
)
where rownum <= 2 
-- 보호시작일 - 입양일이 보호기간