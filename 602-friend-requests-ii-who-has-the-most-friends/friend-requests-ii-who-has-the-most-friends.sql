# Write your MySQL query statement below

SELECT requester_id AS id, COUNT(accepter_id) AS num
FROM (
    SELECT requester_id , accepter_id
    FROM RequestAccepted
    UNION ALL
    SELECT accepter_id, requester_id
    FROM RequestAccepted
) T
GROUP BY requester_id
ORDER BY num DESC
LIMIT 1;