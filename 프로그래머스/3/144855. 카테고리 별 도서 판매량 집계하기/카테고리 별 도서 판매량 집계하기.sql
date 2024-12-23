SELECT CATEGORY, SUM(SALES) TOTAL_SALES
FROM BOOK B
JOIN BOOK_SALES BS
ON B.BOOK_ID = BS.BOOK_ID
WHERE SALES_DATE LIKE '%2022-01%'
GROUP BY CATEGORY
ORDER BY 1;