-- activity 1
-- Select *
-- from city
-- limit 10;

-- Select *
-- from country
-- limit 10;

-- Select *
-- from countrylanguage
-- limit 10;

-- activity 2
-- Select *
-- from city
-- where population < 10000
-- order by population desc;

-- activity 3
-- SELECT co.region, co.name AS country_name, c.name AS city_name
-- FROM city c
-- LEFT JOIN country co ON c.countryCode = co.Code
-- GROUP BY co.region, co.name, c.name
-- ORDER BY co.region ASC, co.name ASC, c.name ASC;

-- activity 4
-- SELECT 
--     c.name AS country_name,
--     LISTAGG(cl.language, ', ') WITHIN GROUP (ORDER BY cl.language) AS french_languages,
--     MAX(cl.percentage) AS percentage
-- FROM 
--     country c
-- JOIN 
--     countrylanguage cl ON c.code = cl.countrycode
-- WHERE 
--     cl.language IN ('Standard French', 'Canadian French', 'African French', 'Belgian French', 'Swiss French')
-- GROUP BY 
--     c.name
-- ORDER BY 
--     percentage DESC;

-- activity 5
-- select name, continent, population
-- from country
-- where IndepYear IS NULL
-- order by name asc

-- activity 6
-- SELECT c.name AS country_name,
--        c.continent,
--        cl.language,
--        cl.percentage
-- FROM country c
-- LEFT JOIN countrylanguage cl ON c.code = cl.countrycode
-- ORDER BY c.name ASC, cl.percentage DESC;

-- activity 7
select c.name, c.continent
from country c
Left join countrylanguage cl ON c.code = cl.countryCode
where c.code IS NULL
order by Continent asc, c.name asc;
