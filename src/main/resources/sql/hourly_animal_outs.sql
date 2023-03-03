select A.HOUR, NVL(B.COUNT,0) FROM (
 select LEVEL-1 AS HOUR FROM DUAL CONNECT BY LEVEL <= 24) A , 
(SELECT 
EXTRACT(HOUR FROM CAST(DATETIME AS TIMESTAMP)) AS HOUR, 
COUNT(*) AS COUNT FROM ANIMAL_OUTS GROUP BY EXTRACT(HOUR FROM CAST(DATETIME AS TIMESTAMP))) B
where B.HOUR (+)= A.HOUR
order by A.HOUR