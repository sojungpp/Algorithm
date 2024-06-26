SELECT AI.ANIMAL_ID, AI.ANIMAL_TYPE, AI.NAME
FROM ANIMAL_INS AI
JOIN ANIMAL_OUTS AO
ON AI.ANIMAL_ID = AO.ANIMAL_ID
WHERE AI.SEX_UPON_INTAKE LIKE 'INTACT %'
AND AO.SEX_UPON_OUTCOME NOT LIKE 'INTACT %';
# 들어올 때는 중성화 X, 나갈 때는 중성화 O