SELECT FP.PRODUCT_ID, FP.PRODUCT_NAME, (FP.PRICE * SUM(AMOUNT)) TOTAL_SALES
FROM FOOD_PRODUCT FP
JOIN FOOD_ORDER FO
ON FP.PRODUCT_ID = FO.PRODUCT_ID
WHERE DATE_FORMAT(PRODUCE_DATE, '%y-%m') = '22-05'
GROUP BY PRODUCT_ID
ORDER BY TOTAL_SALES DESC, FP.PRODUCT_ID ASC;