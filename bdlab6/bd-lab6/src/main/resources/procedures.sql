USE `meteostation`;

DROP PROCEDURE IF EXISTS insertTenAdresses;
DELIMITER //
CREATE PROCEDURE insertTenAdress (
    IN new_adress VARCHAR(45),
    IN new_street VARCHAR(45),
    IN new_build VARCHAR(45))
BEGIN
    DECLARE max_id INT;
    DECLARE idx INT;
    SELECT MAX(id) + 1 INTO max_id FROM `meteostation`.adress;
    IF max_id IS NULL THEN SET max_id=1;
    END IF;
    SET idx = 1;
    label1: WHILE idx < 11 DO
            INSERT INTO `adress` (`adress`, `street`, `build`)
            VALUES (CONCAT(new_adress, idx),CONCAT(new_street, idx), CONCAT(new_build, idx));
            SET max_id = max_id + 1;
            SET idx = idx + 1;
            ITERATE label1;
        END WHILE;
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS DataParamInsert;
DELIMITER //
CREATE PROCEDURE DataParamInsert (
    IN new_temperature INT,
    IN new_humidity INT,
    IN new_wind_speed INT,
    IN new_atmospheric_pressure INT,
    IN new_wind_direction VARCHAR(15),
    IN new_interval_of_updates_id INT)
BEGIN
    INSERT INTO `data` (temperature, humidity, wind_speed, atmospheric_pressure, wind_direction, interval_of_updates_id) VALUES (new_temperature, new_humidity, new_wind_speed, new_atmospheric_pressure, new_wind_direction, new_interval_of_updates_id);
    SELECT id, temperature, humidity, wind_speed, atmospheric_pressure, wind_direction, interval_of_updates_id FROM `data`
    WHERE temperature = new_temperature;
    END //
DELIMITER ;
# and humidity = new_humidity and wind_speed = new_wind_speed and atmospheric_pressure = new_atmospheric_pressure and wind_direction = new_wind_direction and interval_of_updates_id = new_interval_of_updates_id

DROP PROCEDURE IF EXISTS CalcMinTemperature;
DELIMITER //
CREATE PROCEDURE CalcMinTemperature()
BEGIN
    DECLARE label VARCHAR(20);
    SELECT getMinTemp() AS average_temp;
END //



DELIMITER //
DROP PROCEDURE IF EXISTS CreateTablesWithCursor //
CREATE PROCEDURE CreateTablesWithCursor()
BEGIN
    DECLARE done BOOL DEFAULT false;
    DECLARE surname VARCHAR(50);
    DECLARE my_cursor CURSOR
        FOR SELECT name FROM `developer`;

    DECLARE CONTINUE HANDLER
        FOR NOT FOUND SET done = true;

    OPEN my_cursor;
    my_loop: LOOP
        FETCH my_cursor INTO surname;
        IF (done = true) THEN LEAVE my_loop;
        END IF;
        SET @temp_query = CONCAT('CREATE TABLE IF NOT EXISTS ', surname, ' (', surname, '1 INT, ', surname, '2 BOOL);');
        PREPARE my_query FROM @temp_query;
        EXECUTE my_query;
        DEALLOCATE PREPARE my_query;
    END LOOP;
    CLOSE my_cursor;
END //
DELIMITER ;