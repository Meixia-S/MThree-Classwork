-- activity 1
Select *
from city
limit 10;

Select *
from country
limit 10;

Select *
from countrylanguage
limit 10;

-- activity 2
Select *
from city
where population < 10000
order by population desc;

-- activity 3
SELECT co.region, co.name AS country_name, c.name AS city_name
FROM city c
LEFT JOIN country co ON c.countryCode = co.Code
GROUP BY co.region, co.name, c.name
ORDER BY co.region ASC, co.name ASC, c.name ASC;

-- activity 4
SELECT 
		c.name AS country_name,
       LISTAGG(cl.language, ', ') WITHIN GROUP (ORDER BY cl.language) AS french_languages,
       MAX(cl.percentage) AS percentage
FROM country c
JOIN countrylanguage cl ON c.code = cl.countrycode
WHERE cl.language IN ('Standard French', 'Canadian French', 'African French', 'Belgian French', 'Swiss French')
GROUP BY c.name
ORDER BY percentage DESC;

-- activity 5
select name, continent, population
from country
where IndepYear IS NULL
order by name asc;

-- activity 6
SELECT c.name AS country_name, c.continent, cl.language, cl.percentage
FROM country c
LEFT JOIN countrylanguage cl ON c.code = cl.countrycode
ORDER BY c.name ASC, cl.percentage DESC;

-- activity 7
SELECT c.Name AS CountryName, c.Continent
FROM Country c
LEFT JOIN CountryLanguage cl ON c.Code = cl.CountryCode
WHERE cl.Language IS NULL
ORDER BY c.Continent, c.Name;

-- activity 8
select SUM(c.population) AS Population, ct.name
from country ct
left join city c ON ct.code = c.countryCode
group by ct.name
order by Population asc;

-- activity 9
select AVG(c.population) AS AvgPopulation, ct.Continent
from country ct
left join city c ON ct.code = c.countryCode
group by ct.Continent
order by AvgPopulation asc;

-- activity 10
SELECT Name AS CountryName, GNP
FROM Country
ORDER BY GNP DESC
Limit 10;

-- activity 11
SELECT ci.Name AS CityName, 
       co.Name AS CountryName, 
       ci.Population AS CityPopulation, 
       GROUP_CONCAT(cl.Language SEPARATOR ', ') AS OfficialLanguages
FROM Country co
JOIN City ci ON co.Capital = ci.ID
JOIN CountryLanguage cl ON co.Code = cl.CountryCode
GROUP BY ci.Name, co.Name, ci.Population
ORDER BY ci.Name ASC;

-- activity 12
SELECT co.Name AS CountryName, 
       ci.Name AS CapitalCity
FROM Country co
LEFT JOIN City ci ON co.Capital = ci.ID
ORDER BY co.Name ASC;
