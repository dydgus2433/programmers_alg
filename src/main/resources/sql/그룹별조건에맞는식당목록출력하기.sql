-- 코드를 입력하세요
   --MEMBER_PROFILE : min09125@naver.com	이민준	01076482309	M	1992-01-09 00:00:00
   --REST_REVIEW : R000000001	1	min09125@naver.com	5	3시간 넘는 웨이팅이었지만 그래도 가볼만한 곳	2022-03-29 00:00:00
   


--order by 리뷰작성일 asc, 리뷰 텍스트 asc; 
with 
REVIEW_CNT AS (
    SELECT RR.member_id  from MEMBER_PROFILE MP , REST_REVIEW RR
    where MP.member_id = RR.member_id
    group by RR.member_id
    having count(*) = (
         SELECT  max(count(*)) cnt from MEMBER_PROFILE MP , REST_REVIEW RR
        where MP.member_id = RR.member_id
        group by RR.member_id
    )
)
 SELECT MP.MEMBER_NAME,	RR.REVIEW_TEXT, TO_CHAR(RR.REVIEW_DATE, 'YYYY-MM-DD')	AS REVIEW_DATE from MEMBER_PROFILE MP , REST_REVIEW RR , REVIEW_CNT RC
    where MP.member_id = RR.member_id
    and MP.member_id in (RC.member_id)
    order by RR.REVIEW_DATE asc ,  RR.REVIEW_TEXT asc
    
    ;