SELECT mcdp_cd as "진료과코드", count(pt_no) as "5월예약건수"
from 
appointment 
where to_char(apnt_ymd, 'yyyymm') = '202205'
group by mcdp_cd 
order by count(pt_no), mcdp_cd