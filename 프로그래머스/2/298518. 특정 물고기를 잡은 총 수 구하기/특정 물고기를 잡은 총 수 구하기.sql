SELECT COUNT(*) AS FISH_COUNT
FROM FISH_INFO FI
JOIN FISH_NAME_INFO FNI
ON FI.FISH_TYPE = FNI.FISH_TYPE
WHERE FISH_NAME IN("BASS", "SNAPPER");