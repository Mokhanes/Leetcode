WITH weekly_hours AS (
    SELECT
        m.employee_id,
        YEARWEEK(m.meeting_date, 1) AS week_id,  -- ISO week (Mon–Sun)
        SUM(m.duration_hours) AS total_meeting_hours
    FROM meetings m
    GROUP BY m.employee_id, YEARWEEK(m.meeting_date, 1)
),
heavy_weeks AS (
    SELECT
        employee_id,
        COUNT(*) AS meeting_heavy_weeks
    FROM weekly_hours
    WHERE total_meeting_hours > 20      -- strictly more than 50% of 40
    GROUP BY employee_id
    HAVING COUNT(*) >= 2                -- at least 2 weeks
)
SELECT
    e.employee_id,
    e.employee_name,
    e.department,
    hw.meeting_heavy_weeks
FROM heavy_weeks hw
JOIN employees e
  ON e.employee_id = hw.employee_id
ORDER BY
    hw.meeting_heavy_weeks DESC,
    e.employee_name ASC;
