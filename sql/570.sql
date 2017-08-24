# Managers with at Least 5 Direct Reports
# https://leetcode.com/problems/managers-with-at-least-5-direct-reports/description/
Create table If Not Exists Employee (Id int, Name varchar(255), Department varchar(255), ManagerId int);
Truncate table Employee;
insert into Employee (Id, Name, Department, ManagerId) values ('101', 'John', 'A', 'None');
insert into Employee (Id, Name, Department, ManagerId) values ('102', 'Dan', 'A', '101');
insert into Employee (Id, Name, Department, ManagerId) values ('103', 'James', 'A', '101');
insert into Employee (Id, Name, Department, ManagerId) values ('104', 'Amy', 'A', '101');
insert into Employee (Id, Name, Department, ManagerId) values ('105', 'Anne', 'A', '101');
insert into Employee (Id, Name, Department, ManagerId) values ('106', 'Ron', 'B', '101');

SELECT
  man.Name
FROM Employee e
INNER JOIN Employee man ON man.Id = e.ManagerId
WHERE e.ManagerId IS NOT NULL
GROUP BY man.Id
HAVING COUNT(e.Id) >= 5
;