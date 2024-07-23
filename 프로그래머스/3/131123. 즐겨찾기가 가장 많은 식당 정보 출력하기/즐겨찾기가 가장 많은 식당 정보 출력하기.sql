SELECT food_type, rest_id, rest_name, favorites
FROM REST_INFO as r1
WHERE favorites = (
    SELECT MAX(favorites)
    FROM REST_INFO as r2
    WHERE r2.food_type = r1.food_type
)
ORDER BY food_type DESC;
