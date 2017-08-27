# Second Degree Follower
# Link: https://leetcode.com/problems/second-degree-follower/description/

Create table If Not Exists follow (followee varchar(255), follower varchar(255));
Truncate table follow;
insert into follow (followee, follower) values ('A', 'B');
insert into follow (followee, follower) values ('B', 'C');
insert into follow (followee, follower) values ('B', 'D');
insert into follow (followee, follower) values ('D', 'E');


SELECT
  f1.follower AS follower
, COUNT(DISTINCT f2.follower) AS num
FROM follow f1
INNER JOIN follow f2 ON f2.followee = f1.follower
GROUP BY f1.follower
ORDER BY f1.follower ASC
;