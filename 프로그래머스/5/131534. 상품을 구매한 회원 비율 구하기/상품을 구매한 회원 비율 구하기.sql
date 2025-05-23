# 2021년에 가입한 전체 회원 
# 상품을 구매한 회원수와 상품을 구매한 회원의 비율 (소수점 두번째자리에서 반올림)
SELECT YEAR(SALES_DATE) YEAR, MONTH(SALES_DATE) MONTH, COUNT(DISTINCT O.USER_ID) PURCHASED_USERS, 
ROUND(COUNT(DISTINCT O.USER_ID) / (SELECT COUNT(*)
                  FROM USER_INFO
                  WHERE YEAR(JOINED) = '2021'), 1) PUCHASED_RATIO
FROM USER_INFO U
JOIN ONLINE_SALE O
ON U.USER_ID = O.USER_ID
WHERE YEAR(JOINED) = '2021'
GROUP BY YEAR(SALES_DATE), MONTH(SALES_DATE)
ORDER BY 1, 2;