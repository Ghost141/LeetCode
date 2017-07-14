# Write your MySQL query statement below
select
  e.name as Employee
FROM employee e
  INNER JOIN employee man ON man.id = e.managerId
WHERE e.salary > man.salary