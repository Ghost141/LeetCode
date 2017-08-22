Create table If Not Exists triangle (x int, y int, z int);
Truncate table triangle;
insert into triangle (x, y, z) values ('13', '15', '30');
insert into triangle (x, y, z) values ('10', '20', '15');

SELECT
  *
, CASE WHEN x + y > z AND x + z > y AND y + z > x THEN 'Yes' ELSE 'No' END AS triangle
FROM triangle