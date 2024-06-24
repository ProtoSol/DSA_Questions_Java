# Write your MySQL query statement below
SELECT cat.category, COUNT(T.account_id) AS accounts_count
FROM (
    SELECT 'Low Salary' AS category 
    UNION ALL
    SELECT 'Average Salary' 
    UNION ALL
    SELECT 'High Salary'
) cat
LEFT JOIN (
    SELECT *, 
        CASE 
            WHEN income < 20000 THEN 'Low Salary'
            WHEN income BETWEEN 20000 AND 50000 THEN 'Average Salary'
            ELSE 'High Salary' 
        END AS category
    FROM Accounts
) T ON cat.category = T.category
GROUP BY cat.category
ORDER BY 
    CASE 
        WHEN cat.category = 'Low Salary' THEN 1
        WHEN cat.category = 'Average Salary' THEN 2
        WHEN cat.category = 'High Salary' THEN 3
    END;