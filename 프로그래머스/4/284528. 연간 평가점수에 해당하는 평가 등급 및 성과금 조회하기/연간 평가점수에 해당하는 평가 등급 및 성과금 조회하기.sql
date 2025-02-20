SELECT E.EMP_NO, EMP_NAME, CASE WHEN(AVG(SCORE) >= 96) THEN 'S'
                              WHEN(AVG(SCORE) >= 90) THEN 'A'
                              WHEN(AVG(SCORE) >= 80) THEN 'B'
                              ELSE 'C' END GRADE,
                        CASE WHEN(AVG(SCORE) >= 96) THEN SAL*0.2
                             WHEN(AVG(SCORE) >= 90) THEN SAL*0.15
                             WHEN(AVG(SCORE) >= 80) THEN SAL*0.1
                             ELSE SAL*0 END BONUS
FROM HR_DEPARTMENT D
JOIN HR_EMPLOYEES E
ON D.DEPT_ID = E.DEPT_ID
JOIN HR_GRADE G
ON G.EMP_NO = E.EMP_NO
GROUP BY EMP_NO, YEAR
ORDER BY 1;
