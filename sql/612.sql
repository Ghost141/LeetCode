# Shortest Distance in a Plane
# Link: https://leetcode.com/problems/shortest-distance-in-a-plane/description/

CREATE TABLE If Not Exists point_2d (x INT NOT NULL, y INT NOT NULL);
Truncate table point_2d;
insert into point_2d (x, y) values ('-1', '-1');
insert into point_2d (x, y) values ('0', '0');
insert into point_2d (x, y) values ('-1', '-2');

SELECT
  MIN(ROUND(SQRT(POW(p.x - p2.x, 2) + POW(p.y - p2.y, 2)), 2)) AS shortest
FROM point_2d p
JOIN point_2d p2 ON p.x != p2.x OR p.y != p2.y
;