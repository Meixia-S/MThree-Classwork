use personaltrainer;


-- SELECT Queries --

-- activity 1
Select *
from exercise;

-- activity 2
Select *
from client;

-- activity 3
Select *
from client
where city = "Metairie";

-- activity 4
Select *
from client
where ClientId = 818u7faf-7b4b-48a2-bf12-7a26c92de20c;

-- activity 5
select *
from Goal;

-- activity 6
Select name, levelid
from Workout;

-- activity 7
Select Name, LevelId, Notes 
from Workout
where LevelId = 2;

-- activity 8
SELECT FirstName, LastName, City
FROM Client
WHERE City IN ('Metairie', 'Kenner', 'Gretna');

-- activity 9
SELECT FirstName, LastName, BirthDate
FROM Client
WHERE BirthDate BETWEEN '1980-01-01' AND '1989-12-31';

-- activity 10
SELECT FirstName, LastName, BirthDate
FROM Client
WHERE BirthDate >= '1980-01-01' AND BirthDate <= '1989-12-31';

-- activity 11
Select *
from login
where EmailAddress LIKE '%.gov';

-- activity 12
Select *
from login
where EmailAddress NOT LIKE '%.com';

-- activity 13
select FirstName, LastName
from client
where BirthDate IS NULL;

-- activity 14
Select name
from exercisecategory
where ParentCategoryId IS NOT NULL;

-- activity 15
Select Name, Notes
from workout
where levelId = 3 AND Notes LIKE '%you%';

-- activity 16
Select FirstName, LastName, City
from Client
where (LastName LIKE 'L%' or  
	  LastName LIKE 'M%' or  
      LastName LIKE 'N%') AND City = 'LaPlace';

-- activity 17
SELECT InvoiceId, Description, Price, Quantity, ServiceDate, 
       (Price * Quantity) AS LineItemTotal
from InvoiceLineItem
where (Price * Quantity) BETWEEN 15 AND 25;

-- activity 18
SELECT c.ClientId, c.FirstName, c.LastName, l.EmailAddress
FROM Client c
LEFT JOIN Login l ON c.ClientId = l.ClientId
WHERE c.FirstName = 'Estrella' AND c.LastName = 'Bazely';

-- activity 19 
SELECT WorkoutId
FROM Workout
WHERE Name = 'This Is Parkour';

SELECT GoalId
FROM WorkoutGoal
WHERE WorkoutId = 123;

SELECT GoalName
FROM Goal
WHERE GoalId IN (1, 2, 3);


-- JOIN Queries -- 

-- activity 1
SELECT *
FROM Exercise e
JOIN ExerciseCategory ec
ON e.ExerciseCategoryId = ec.ExerciseCategoryId;

-- activity 2
SELECT ec.Name, e.Name
FROM Exercise e
JOIN ExerciseCategory ec ON e.ExerciseCategoryId = ec.ExerciseCategoryId
WHERE ec.ParentCategoryId IS NULL;

-- activity 3
SELECT ec.Name AS CategoryName, e.Name AS ExerciseName
FROM Exercise e
JOIN ExerciseCategory ec ON e.ExerciseCategoryId = ec.ExerciseCategoryId
WHERE ec.ParentCategoryId IS NULL;

-- activity 4
SELECT c.FirstName, c.LastName, c.BirthDate, l.EmailAddress
FROM Client c
JOIN Login l ON c.ClientId = l.ClientId
WHERE c.BirthDate BETWEEN '1990-01-01' AND '1999-12-31';

-- activity 5
SELECT w.Name AS WorkoutName, c.FirstName, c.LastName
FROM Client c
JOIN ClientWorkout cw ON c.ClientId = cw.ClientId
JOIN Workout w ON cw.WorkoutId = w.WorkoutId
WHERE c.LastName LIKE 'C%';

-- activity 6
SELECT w.Name AS WorkoutName, g.Name AS GoalName
FROM Workout w
JOIN WorkoutGoal wg ON w.WorkoutId = wg.WorkoutId
JOIN Goal g ON wg.GoalId = g.GoalId;

-- acitivity 7
SELECT c.FirstName, c.LastName, l.clientID, l.EmailAddress
FROM Client c
LEFT JOIN Login l ON c.ClientId = l.ClientId;

SELECT c.FirstName, c.LastName, l.clientID, l.EmailAddress
FROM Client c
LEFT JOIN Login l ON c.ClientId = l.ClientId
WHERE l.ClientId IS NULL;

-- activity 8
SELECT c.FirstName, c.LastName, l.ClientID
FROM Client c
LEFT JOIN Login l ON c.ClientId = l.ClientId
WHERE c.FirstName = 'Romeo' AND c.LastName = 'Seaward';

-- activity 9
SELECT e.Name AS CategoryName, ep.Name AS ParentCategoryName
from ExerciseCategory e
JOIN ExerciseCategory ep ON e.ParentCategoryID = ep.ExerciseCategoryID;

-- activity 10
SELECT ec1.Name AS CategoryName, ec2.Name AS ParentCategoryName
FROM ExerciseCategory ec1
LEFT JOIN ExerciseCategory ec2 ON ec1.ParentCategoryId = ec2.ExerciseCategoryId;

-- activity 11
SELECT c.FirstName, c.LastName
FROM Client c
LEFT JOIN ClientWorkout cw ON c.ClientId = cw.ClientId
WHERE cw.ClientId IS NULL;

-- activity 12
wording was confusing...
SELECT DISTINCT w.Name AS WorkoutName
FROM Workout w
JOIN WorkoutGoal wg ON w.WorkoutId = wg.WorkoutId
JOIN Goal g ON wg.GoalId = g.GoalId
JOIN ClientGoal cg ON g.GoalId = cg.GoalId
JOIN Client c ON cg.ClientId = c.ClientId
WHERE c.FirstName = 'Shell' AND c.LastName = 'Creane'
AND w.Level = 'Beginner';

-- activity 13
SELECT w.Name AS WorkoutName, e.Name AS ExerciseName
FROM Workout w
JOIN WorkoutDay wd ON w.WorkoutId = wd.WorkoutId
JOIN WorkoutDayExerciseInstance wdei ON wd.WorkoutDayId = wdei.WorkoutDayId
JOIN ExerciseInstance ei ON wdei.ExerciseInstanceId = ei.ExerciseInstanceId
JOIN Exercise e ON ei.ExerciseId = e.ExerciseId;

-- activity 14
SELECT e.Name AS ExerciseName, eiv.Value, u.Name AS UnitName
FROM Exercise e
JOIN ExerciseInstance ei ON e.ExerciseId = ei.ExerciseId
JOIN ExerciseInstanceUnitValue eiv ON ei.ExerciseInstanceId = eiv.ExerciseInstanceId
JOIN Unit u ON eiv.UnitId = u.UnitId
WHERE e.Name = 'Plank';


-- Grouping and Sorting -- 

-- activity 1
Select Count(*) AS TotalClientCount
from Client;

-- activity 2
SELECT COUNT(BirthDate) AS BirthDateCount
FROM Client;

-- activity 3
Select city, COUNT(*) AS client_count
from Client
Where city IN ("New Orleans", "Jefferson")
Group By city;

-- activity 4
SELECT InvoiceId, 
       SUM(Price * Quantity) AS TotalPerInvoice
FROM InvoiceLineItem
GROUP BY InvoiceId;

-- activity 5
SELECT InvoiceId, 
       SUM(Price * Quantity) AS TotalPerInvoice
FROM InvoiceLineItem
GROUP BY InvoiceId
HAVING SUM(Price * Quantity) > 500
ORDER BY TotalPerInvoice ASC;

-- activity 6
SELECT Description, 
       AVG(Price * Quantity) AS AverageLineItemTotal
FROM InvoiceLineItem
GROUP BY Description;

-- activity 7
SELECT c.ClientId, c.FirstName, c.LastName
FROM Client c
JOIN Invoice i ON c.ClientId = i.ClientId
JOIN InvoiceLineItem il ON i.InvoiceId = il.InvoiceId
WHERE i.InvoiceStatus = 2
GROUP BY c.ClientId, c.FirstName, c.LastName
HAVING SUM(il.Price * il.Quantity) > 1000
ORDER BY c.LastName, c.FirstName;

-- activity 8
SELECT ec.Name AS CategoryName, COUNT(e.ExerciseId) AS ExerciseCount
FROM ExerciseCategory ec
JOIN Exercise e ON ec.ExerciseCategoryId = e.ExerciseCategoryId
GROUP BY ec.Name
ORDER BY ExerciseCount DESC;

-- activity 9
SELECT e.Name AS ExerciseName, 
       MIN(ei.Sets) AS MinSets, 
       MAX(ei.Sets) AS MaxSets, 
       AVG(ei.Sets) AS AvgSets
FROM Exercise e
JOIN ExerciseInstance ei ON e.ExerciseId = ei.ExerciseId
GROUP BY e.Name
ORDER BY e.Name;

-- activity 10
SELECT w.Name AS WorkoutName, 
       MIN(c.BirthDate) AS MinBirthDate, 
       MAX(c.BirthDate) AS MaxBirthDate
FROM Workout w
JOIN ClientWorkout cw ON w.WorkoutId = cw.WorkoutId
JOIN Client c ON cw.ClientId = c.ClientId
GROUP BY w.Name
ORDER BY w.Name;

-- activity 11
SELECT c.ClientId, c.FirstName, c.LastName, COUNT(cg.GoalId) AS GoalCount
FROM Client c
LEFT JOIN ClientGoal cg ON c.ClientId = cg.ClientId
GROUP BY c.ClientId, c.FirstName, c.LastName
ORDER BY GoalCount DESC;

-- activity 12
SELECT e.Name AS ExerciseName, 
       u.Name AS UnitName, 
       MIN(eiuv.Value) AS MinVal, 
       MAX(eiuv.Value) AS MaxVal
FROM Exercise e
JOIN WorkoutDayExerciseInstance wdei ON e.ExerciseId = wdei.ExerciseId
JOIN ExerciseInstance ei ON wdei.ExerciseInstanceId = ei.ExerciseInstanceId
JOIN ExerciseInstanceUnitValue eiuv ON ei.ExerciseInstanceId = eiuv.ExerciseInstanceId
JOIN Unit u ON eiuv.UnitId = u.UnitId
GROUP BY e.Name, u.Name
ORDER BY e.Name, u.Name;

-- activity 13
SELECT ec.Name AS ExerciseCategoryName, 
       e.Name AS ExerciseName, 
       u.Name AS UnitName, 
       MIN(eiuv.Value) AS MinV, 
       MAX(eiuv.Value) AS MaxV
FROM Exercise e
JOIN ExerciseCategory ec ON e.ExerciseCategoryId = ec.ExerciseCategoryId
JOIN ExerciseInstance ei ON e.ExerciseId = ei.ExerciseId
JOIN ExerciseInstanceUnitValue eiuv ON ei.ExerciseInstanceId = eiuv.ExerciseInstanceId
JOIN Unit u ON eiuv.UnitId = u.UnitId
GROUP BY ec.ExerciseCategoryId, ec.Name, e.ExerciseId, e.Name, u.UnitId, u.Name
ORDER BY ec.Name, e.Name, u.Name;

-- activity 14
SELECT 
    l.Name AS LevelName, 
    MIN(TIMESTAMPDIFF(YEAR, c.BirthDate, CURDATE())) AS MinAge,
    MAX(TIMESTAMPDIFF(YEAR, c.BirthDate, CURDATE())) AS MaxAge
FROM Client c
LEFT JOIN ClientWorkout cwo ON c.ClientID = cwo.ClientID
LEFT JOIN Workout wo ON cwo.WorkoutID = wo.WorkoutID
LEFT JOIN Level l ON wo.LevelID = l.LevelID
where l.levelid IS NOT NULL
GROUP BY l.Name
ORDER BY l.Name;

-- activity 15
SELECT SUBSTRING_INDEX(EmailAddress, '.', -1) AS EmailExtension,
       COUNT(*) AS LoginCount
FROM Login
GROUP BY EmailExtension
ORDER BY LoginCount DESC;

-- activity 16
SELECT 
    c.FirstName,
    c.LastName,
    w.Name AS WorkoutName
FROM Client c
JOIN ClientGoal cg ON c.ClientId = cg.ClientId
JOIN WorkoutGoal wg ON cg.GoalId = wg.GoalId
JOIN Workout w ON wg.WorkoutId = w.WorkoutId
GROUP BY c.ClientId, w.WorkoutId
HAVING COUNT(wg.GoalId) >= 2
ORDER BY c.LastName, c.FirstName;