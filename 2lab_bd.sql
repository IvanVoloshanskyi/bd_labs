-- БД «Аеропорт». Знайдіть номери всіх рейсів, на яких курсує літак
-- 'TU-134'. Вивести: trip_no, plane, town_from, town_to. Вихідні дані
-- впорядкувати за спаданням за стовпцем time_out.
-- ORDER BY time_out DESC-> SORTING(small -> big)
SELECT trip_no, plane, town_from, town_to, time_out FROM labor_sql.trip
WHERE plane = 'TU-154'
ORDER BY time_out DESC

-- 2. БД «Комп. фірма». Вивести всі моделі ПК, у номерах яких є хоча б
-- дві одинички.
SELECT * FROM labor_sql.pc
WHERE model LIKE '%11%'

-- 3. БД «Кораблі». Знайдіть країни, що мали класи як звичайних бойо-
-- вих кораблів 'bb', так і класи крейсерів 'bc'. Вивести: country, типи із
-- класом 'bb', типи із класом 'bc'.
-- SELECT country, type FROM classes

SELECT country, type FROM classes
WHERE type = 'bb' AND country IN 
(SELECT country FROM classes
WHERE type = 'bc');


-- 4. БД «Кораблі». Знайдіть кораблі, «збережені для майбутніх битв»,
-- тобто такі, що були виведені з ладу в одній битві ('damaged'), а потім
-- (пізніше в часі) знову брали участь у битвах. Вивести: ship, battle, date.
SELECT DISTINCT ship, battle FROM outcomes, battles
WHERE result LIKE 'damaged';

-- 5. БД «Комп. фірма». Знайдіть виробників принтерів, що випускають
-- ПК із найменшим об’ємом RAM. Виведіть: maker.

SELECT * FROM product
LEFT JOIN pc
ON product.model=pc.model
WHERE ram = ANY(SELECT min(ram) from pc) AND maker in (SELECT maker FROM product WHERE type = 'Printer')
GROUP BY maker;

-- 6. БД «Аеропорт». Вивести дані для таблиці Trip з об’єднаними зна-
-- ченнями двох стовпців: town_from та town_to, з додатковими комента-
-- рями типу: 'from Rostov to Paris'.
SELECT CONCAT('From ',town_from, ' to ',town_to) FROM labor_sql.trip;


-- 7. БД «Комп. фірма». Знайти моделі та ціни ПК, вартість яких пере-
-- вищує мінімальну вартість ноутбуків. Вивести: model, price.
SELECT DISTINCT model, price FROM PC
WHERE price > (SELECT MIN(price) FROM Laptop);

-- 8. БД «Комп. фірма». Знайдіть виробників, які б випускали ПК із міні-
-- мальною швидкістю не менше 500 МГц. Вивести: maker, мінімальна

-- швидкість. (Підказка: використовувати підзапити в якості обчислю-
-- вальних стовпців)
SELECT maker, MIN(speed), type FROM labor_sql.product
INNER JOIN pc
WHERE (product.model = pc.model) AND speed > 500 
group by speed


-- 10. БД «Комп. фірма». Для кожної моделі продукції з усієї БД виведіть
-- її найвищу ціну. Вивести: type, model, максимальна ціна. (Підказка:
-- використовувати оператор UNION)
SELECT product.type, devices.model, avg(devices.price) as avg_price FROM product INNER JOIN (
SELECT model, price FROM pc
UNION
SELECT model, price FROM laptop 
UNION
SELECT model, price FROM printer
ORDER BY model) AS devices ON product.model=devices.model GROUP BY devices.model
