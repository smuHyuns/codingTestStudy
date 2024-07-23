-- 코드를 입력하세요
SELECT ai.name, ai.datetime
from animal_ins as ai
left join animal_outs as ao
on ai.animal_id = ao.animal_id
where ao.animal_id is null
order by datetime asc
limit 3