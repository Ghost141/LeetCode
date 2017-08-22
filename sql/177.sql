CREATE TABLE Employee (
  Id INT NOT NULL,
  Salary INT
);

CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
  BEGIN
    DECLARE off INT;
    SET off = N - 1;
    RETURN (
      # Write your MySQL query statement below.
      SELECT DISTINCT Salary
      FROM Employee
      ORDER BY Salary DESC
      LIMIT 1 OFFSET off
    );
  END