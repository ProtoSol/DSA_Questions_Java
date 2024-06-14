# Write your MySQL query statement below

SELECT tweet_id
FROM Tweets
WHERE CHAR_LENGTH(content) > 15;

-- LENGTH function counts the number in the form of bytes not integer,