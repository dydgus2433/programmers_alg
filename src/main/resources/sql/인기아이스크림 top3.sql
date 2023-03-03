select flavor from (
    
select flavor,s1 
    from (SELECT b.flavor, sum(a.total_order+b.t2)  s1   
          from first_half a ,
  (  select flavor, sum(total_order) t2 
   from    july group by flavor) b 
          where  b.flavor = a.flavor(+) group by b.flavor ) order by s1 desc) 
          where rownum < 4