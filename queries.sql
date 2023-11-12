--Part 1
 SELECT *
 FROM job;

--Part 2
SELECT name
FROM employer
WHERE location = "St. Louis City";

--Part 3
DROP TABLE job;

--Part 4

-- Task 4.5 write query to return the names of all skills that are attached to jobs in alphabetical order
-- If a skill does not have a job listed, it should not be included in the results of this query.
SELECT * FROM skill
LEFT JOIN job_skills
ON skill.id = job_skills.skills_id
WHERE job_skills.jobs_id IS NOT NULL
ORDER BY name ASC