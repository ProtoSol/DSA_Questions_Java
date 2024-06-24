# Write your MySQL query statement below

(   SELECT u.name AS results
    FROM MovieRating m
    LEFT JOIN Users u
    ON m.user_id = u.user_id
    GROUP BY u.name
    ORDER BY COUNT(DISTINCT movie_id) DESC, name ASC
    LIMIT 1
)
UNION ALL
(   SELECT m2.title
    FROM MovieRating m1
    LEFT JOIN Movies m2
    ON m1.movie_id = m2.movie_id
    WHERE DATE_FORMAT(created_at,'%Y-%m') = '2020-02'
    GROUP BY m2.title
    ORDER BY AVG(m1.rating) DESC, m2.title ASC
    LIMIT 1
);