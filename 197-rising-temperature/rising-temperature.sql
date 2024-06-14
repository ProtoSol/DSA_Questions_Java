# Write your MySQL query statement below

-- SELECT w1.id
-- FROM Weather w1, Weather w2
-- WHERE DATEDIFF(w1.recordDate, w2.recordDate) = 1 
-- AND w1.temperature > w2.temperature;

SELECT w1.id
FROM Weather w1
LEFT JOIN Weather w2
ON w1.recordDate - INTERVAL 1 DAY = w2.recordDate
WHERE w1.temperature > w2.temperature;

-- This creates a problem as It thinks of dates as Number to solve we Use INTERVAL 1 Day