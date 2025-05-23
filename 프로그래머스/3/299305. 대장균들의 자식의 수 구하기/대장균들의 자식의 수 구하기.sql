SELECT ID, IFNULL((SELECT COUNT(*)
                    FROM ECOLI_DATA
                    GROUP BY PARENT_ID
                    HAVING PARENT_ID = ID), 0) CHILD_COUNT
FROM ECOLI_DATA
ORDER BY 1 ASC;