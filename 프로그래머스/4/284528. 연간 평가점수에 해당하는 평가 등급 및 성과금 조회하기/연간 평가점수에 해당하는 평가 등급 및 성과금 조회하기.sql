# 사원별 성과금 정보 조회
SELECT E.EMP_NO, EMP_NAME, CASE WHEN AVG(SCORE) >= 98 THEN 'S'
                                WHEN AVG(SCORE) >= 90 THEN 'A'
                                WHEN AVG(SCORE) >= 80 THEN 'B'
                                ELSE 'C' END GRADE,
                           CASE WHEN AVG(SCORE) >= 98 THEN SAL*0.2
                                WHEN AVG(SCORE) >= 90 THEN SAL*0.15
                                WHEN AVG(SCORE) >= 80 THEN SAL*0.1
                                ELSE 0 END BONUS
FROM HR_EMPLOYEES E
JOIN HR_DEPARTMENT D
ON E.DEPT_ID = D.DEPT_ID
JOIN HR_GRADE G
ON E.EMP_NO = G.EMP_NO
GROUP BY 1
ORDER BY 1 ASC;