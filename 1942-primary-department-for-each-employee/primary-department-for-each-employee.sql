# Write your MySQL query statement below

SELECT 
    e.employee_id, 
    e.department_id
FROM Employee e
LEFT JOIN (
    SELECT 
        employee_id, 
        COUNT(department_id) AS num_dept
    FROM Employee
    GROUP BY employee_id
) T 
ON e.employee_id = T.employee_id
WHERE 
    T.num_dept = 1
    OR (T.num_dept > 1 AND e.primary_flag = 'Y');