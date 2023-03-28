SELECT a.category, sum(b.sales) as TOTAL_SALES from BOOK_SALES B, BOOK A
-- book_id	category	author_id	price	published_date 1	경제	1	9000	2020-01-10 00:00:00
-- BOOK_SALES B,-- book_id	sales_date	sales 2	2022-01-01 00:00:00	5
 where a.book_id = b.book_id and TO_CHAR(B.SALES_DATE,'YYYYMM') = '202201'
 group by a.category 
 order by a.category asc
; 