CREATE TABLE courses (
  student VARCHAR(200) NOT NULL,
  class VARCHAR(200) NOT NULL
);

SELECT class
FROM courses
GROUP BY class
HAVING COUNT(DISTINCT student) >= 5