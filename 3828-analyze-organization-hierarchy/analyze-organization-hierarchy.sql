# Write your MySQL query statement below
WITH RECURSIVE hierarchy AS (
    -- Base case: CEO (manager_id is null)
    SELECT
        e.employee_id,
        e.employee_name,
        e.manager_id,
        e.salary,
        1 AS level
    FROM Employees e
    WHERE e.manager_id IS NULL

    UNION ALL

    -- Recursive step: attach employees to their managers
    SELECT
        e.employee_id,
        e.employee_name,
        e.manager_id,
        e.salary,
        h.level + 1
    FROM Employees e
    JOIN hierarchy h
      ON e.manager_id = h.employee_id
),

-- Build full descendant mapping (for budget & team size)
descendants AS (
    -- each employee is their own descendant
    SELECT
        e.employee_id AS manager_id,
        e.employee_id AS subordinate_id
    FROM Employees e

    UNION ALL

    -- recursive expansion: subordinate's subordinates
    SELECT
        d.manager_id,
        e.employee_id
    FROM descendants d
    JOIN Employees e
      ON e.manager_id = d.subordinate_id
),

-- Aggregate salaries and counts
agg AS (
    SELECT
        d.manager_id AS employee_id,
        COUNT(*) - 1 AS team_size,                -- exclude self
        SUM(e.salary) AS budget
    FROM descendants d
    JOIN Employees e
      ON d.subordinate_id = e.employee_id
    GROUP BY d.manager_id
)

SELECT
    h.employee_id,
    h.employee_name,
    h.level,
    a.team_size,
    a.budget
FROM hierarchy h
JOIN agg a
  ON h.employee_id = a.employee_id
ORDER BY
    h.level ASC,
    a.budget DESC,
    h.employee_name ASC;
