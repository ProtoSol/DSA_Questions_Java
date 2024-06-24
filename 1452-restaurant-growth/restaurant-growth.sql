# Write your MySQL query statement below
WITH cstmr AS
(SELECT visited_on, SUM(amount) AS amount
FROM Customer
GROUP BY visited_on)

SELECT c1.visited_on, SUM(c2.amount) AS amount, ROUND(AVG(c2.amount),2) AS average_amount FROM cstmr c1
LEFT JOIN cstmr c2
ON c1.visited_on >= c2.visited_on
WHERE DATEDIFF(c1.visited_on, c2.visited_on) BETWEEN 0 AND 6
AND c1.visited_on >= (SELECT DATE_ADD(MIN(visited_on), INTERVAL 6 DAY) FROM Customer)
GROUP BY c1.visited_on
ORDER BY c1.visited_on;