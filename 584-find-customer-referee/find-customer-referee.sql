# Write your MySQL query statement below
-- SELECT name
-- FROM Customer
-- WHERE referee_id != 2 OR referee_id IS NULL;

SELECT name
FROM Customer
WHERE IFNULL(referee_id,-1) <> 2;

-- COALESCE is used if multiple Column has null value present.