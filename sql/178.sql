CREATE TABLE Scores (
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  score DOUBLE
);

SET @num = 1;
SELECT
  cur.score AS Score
, (SELECT COUNT(*) FROM (SELECT DISTINCT score FROM Scores ORDER BY score DESC) tmp WHERE cur.score >= tmp.score) AS Rank
FROM Scores cur
ORDER BY cur.score DESC
;