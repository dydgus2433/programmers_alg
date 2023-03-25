SELECT a.ANIMAL_ID as ANIMAL_ID,	a.ANIMAL_TYPE as ANIMAL_TYPE,	a.NAME as NAME from  ANIMAL_INS a,-- A383036	Cat	2014-05-29 12:31:00	Normal	Oreo	Neutered Male
ANIMAL_OUTS b -- A395451	Dog	2016-01-03 15:54:00	Logan	Neutered Male
where a.animal_id = b.animal_id (+)
and a.SEX_UPON_INTAKE  like '%Intact%' 
and (b.SEX_UPON_OUTCOME like '%Neutered%'  or b.SEX_UPON_OUTCOME like '%Spayed%'  )