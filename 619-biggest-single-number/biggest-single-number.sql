# Write your MySQL query statement below

SELECT MAX(T.num) AS num
FROM (
    SELECT num
    FROM MyNumbers
    GROUP BY num
    HAVING COUNT(num) = 1
    ORDER BY num DESC 
    LIMIT 1
) T
;