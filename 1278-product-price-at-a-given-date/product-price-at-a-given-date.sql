-- Get a table with the Date diff
WITH data AS (SELECT *, DATEDIFF("2019-08-16", change_date) AS diff FROM Products)
-- Make a table that contains if the diff is -ve => 0 and price when it was changed
-- SELECT data.*, d2.min_diff, CASE WHEN data.diff = d2.min_diff THEN new_price WHEN data.diff <> d2.min_diff THEN 0 ELSE NULL END AS price
-- FROM data
-- LEFT JOIN
-- (SELECT product_id, MIN(diff) AS min_diff FROM data WHERE diff >= 0 GROUP BY product_id) d2
-- ON data.product_id = d2.product_id

SELECT T.product_id, IFNULL(SUM(T.price), 10) as price
FROM (
    SELECT data.*, d2.min_diff, CASE WHEN data.diff = d2.min_diff THEN new_price WHEN data.diff <> d2.min_diff THEN 0 ELSE NULL END AS price
    FROM data
    LEFT JOIN
    (SELECT product_id, MIN(diff) AS min_diff FROM data WHERE diff >= 0 GROUP BY product_id) d2
    ON data.product_id = d2.product_id
) T
GROUP BY
    T.product_id
;