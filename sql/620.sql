CREATE TABLE cinema (
  id INT NOT NULL PRIMARY KEY ,
  movie VARCHAR(200) NOT NULL ,
  description VARCHAR(200) NOT NULL ,
  rating DOUBLE NOT NULL
);

SELECT *
FROM cinema
WHERE id % 2 = 1 AND description != 'boring'
ORDER BY rating DESC
;