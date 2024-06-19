# Write your MySQL query statement below

-- Beginner

-- SELECT ROUND(AVG(IF(d.order_date = d.customer_pref_delivery_date, 1, 0)) * 100, 2) AS immediate_percentage
-- FROM Delivery d
-- LEFT JOIN (SELECT customer_id, MIN(order_date) as first_order_date FROM Delivery GROUP BY Customer_id) f
-- ON d.customer_id = f.customer_id
-- WHERE d.order_date = f.first_order_date;

-- Intermediate

-- SELECT ROUND(AVG(IF(order_date = customer_pref_delivery_date, 1, 0))*100,2) AS immediate_percentage
-- FROM Delivery
-- WHERE (customer_id, order_date) IN (SELECT customer_id, MIN(order_date)
-- FROM Delivery
-- GROUP BY customer_id);

-- ADVANCED (WINDOW FUNCTION)
-- We will be Ranking the dates and keeping the first rank

SELECT ROUND(AVG(IF(order_date = customer_pref_delivery_date, 1, 0))*100,2) AS immediate_percentage
FROM (Select *, DENSE_RANK() OVER(PARTITION BY customer_id ORDER BY order_date ASC) AS order_rank 
FROM Delivery) as order_ranking
WHERE order_rank = 1;