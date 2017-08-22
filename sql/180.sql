Create table If Not Exists Logs (Id int, Num int);
Truncate table Logs;
insert into Logs (Id, Num) values ('1', '1');
insert into Logs (Id, Num) values ('2', '1');
insert into Logs (Id, Num) values ('3', '1');
insert into Logs (Id, Num) values ('4', '2');
insert into Logs (Id, Num) values ('5', '1');
insert into Logs (Id, Num) values ('6', '2');
insert into Logs (Id, Num) values ('7', '2');

SELECT DISTINCT l1.Num AS ConsecutiveNums
FROM Logs l1
INNER JOIN Logs l2 ON l1.Num = l2.Num AND l2.Id = l1.Id + 1
INNER JOIN Logs l3 ON l2.Num = l3.Num AND l3.Id = l2.Id + 1