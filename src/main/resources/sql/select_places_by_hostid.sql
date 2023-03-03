select ID, NAME, HOST_ID FROM PLACES
where HOST_ID  in (SELECT  HOST_ID FROM PLACES 
group by host_id
having   count(host_id) > 1)
order by id