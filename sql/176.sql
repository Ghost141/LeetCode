SELECT
DISTINCT salary AS SecondHighestSalary
FROM employee e
Union select null
ORDER BY salary DESC
LIMIT 1 OFFSET 1