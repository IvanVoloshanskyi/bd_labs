USE `meteostation`;

DROP FUNCTION IF EXISTS getAverageTemperature;
DELIMITER //
CREATE FUNCTION getAverageTemperature()
    RETURNS DECIMAL(8, 2)
    DETERMINISTIC
BEGIN
    RETURN (SELECT MAX(temperature) FROM `meteostation`.data);
END //
DELIMITER ;
