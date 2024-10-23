SELECT MEMBER_ID, MEMBER_NAME, GENDER, DATE_FORMAT(DATE_OF_BIRTH, '%Y-%m-%d') DATE_OF_BIRTH
FROM MEMBER_PROFILE
WHERE GENDER = 'W'
AND MONTH(DATE_OF_BIRTH) = '03'
AND TLNO IS NOT NULL
ORDER BY MEMBER_ID ASC;