SELECT 
    COUNT(F.FISH_TYPE) AS FISH_COUNT, 
    FNI.FISH_NAME AS FISH_NAME
FROM FISH_INFO F
LEFT JOIN FISH_NAME_INFO FNI 
    ON FNI.FISH_TYPE = F.FISH_TYPE
GROUP BY F.FISH_TYPE, FNI.FISH_NAME
ORDER BY FISH_COUNT DESC;
