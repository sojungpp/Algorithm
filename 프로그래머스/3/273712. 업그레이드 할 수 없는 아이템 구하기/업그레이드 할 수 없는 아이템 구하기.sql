SELECT II.ITEM_ID, ITEM_NAME, RARITY
FROM ITEM_INFO II
LEFT JOIN ITEM_TREE IT
ON IT.PARENT_ITEM_ID = II.ITEM_ID
WHERE PARENT_ITEM_ID IS NULL
ORDER BY ITEM_ID DESC;