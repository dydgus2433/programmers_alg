car_id	car_type	fee
3	세단	1518000
23	세단	1380000
27	SUV	655500
18	SUV	627000


세단	30일 이상	8
	SUV	30일 이상	5
/* CAR_RENTAL_COMPANY_CAR  -- 대여중
CAR_RENTAL_COMPANY_DISCOUNT_PLAN  --대여기간 종류별 할인정책 정보
CAR_RENTAL_COMPANY_RENTAL_HISTORY  -- 대여기록

;*/

--select * from car_rental_company_car; -- 24	세단	184000	주차감지센서,스마트키,열선시트,후방카메라

-- select * from CAR_RENTAL_COMPANY_DISCOUNT_PLAN; --2	세단	30일 이상	8
--select * from CAR_RENTAL_COMPANY_RENTAL_HISTORY; -- 721	21	2022-10-30 00:00:00	2022-11-02 00:00:00

--2022-09-07 00:00:00	2022-12-06 00:00:00

select  a.CAR_ID, a.CAR_TYPE
, ROUND(a.daily_fee * (100 - b.discount_rate ) * 0.01 * 
        30) as FEE from car_rental_company_car a, car_rental_company_discount_plan b
where a.car_type = b.car_type  and  a.car_type in ('세단','SUV')  and b.duration_type = '30일 이상' 
 and a.car_id not in 
 (select distinct car_id from car_rental_company_rental_history c where (c.start_date <= TO_DATE('2022-11-30', 'YYYY-MM-DD')
and  c.end_date >= TO_DATE('2022-11-01', 'YYYY-MM-DD') ))
and ROUND(a.daily_fee * (100 - b.discount_rate ) * 0.01 * 30 ) >= 500000
and ROUND(a.daily_fee * (100 - b.discount_rate ) * 0.01 * 30 ) < 2000000

group by a.CAR_ID, a.CAR_TYPE, a.daily_fee, b.discount_rate

order by fee desc, car_type asc, car_id desc ; 
