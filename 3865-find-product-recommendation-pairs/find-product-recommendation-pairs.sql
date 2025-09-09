# Write your MySQL query statement below
WITH product_pairs AS (
    SELECT
        p1.user_id,
        LEAST(p1.product_id, p2.product_id) AS product1_id,
        GREATEST(p1.product_id, p2.product_id) AS product2_id
    FROM ProductPurchases p1
    JOIN ProductPurchases p2
      ON p1.user_id = p2.user_id
     AND p1.product_id < p2.product_id   -- ensures product1 < product2
    GROUP BY p1.user_id, product1_id, product2_id
),
pair_counts AS (
    SELECT
        product1_id,
        product2_id,
        COUNT(DISTINCT user_id) AS customer_count
    FROM product_pairs
    GROUP BY product1_id, product2_id
    HAVING COUNT(DISTINCT user_id) >= 3
)
SELECT
    pc.product1_id,
    pc.product2_id,
    pi1.category AS product1_category,
    pi2.category AS product2_category,
    pc.customer_count
FROM pair_counts pc
JOIN ProductInfo pi1
  ON pc.product1_id = pi1.product_id
JOIN ProductInfo pi2
  ON pc.product2_id = pi2.product_id
ORDER BY
    pc.customer_count DESC,
    pc.product1_id ASC,
    pc.product2_id ASC;
