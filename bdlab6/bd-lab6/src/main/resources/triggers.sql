DELIMITER //
DROP TRIGGER IF EXISTS AddInterval //
CREATE TRIGGER AddInterval
    BEFORE INSERT
    ON `meteostation`.`data` FOR EACH ROW
BEGIN
    IF(NOT EXISTS(
            SELECT id FROM `meteostation`.`interval_of_updates`
            WHERE id = NEW.interval_of_updates_id
        ))
    THEN SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Error! No interval with such id';
    END IF;
END //
DELIMITER ;

DELIMITER //
DROP TRIGGER IF EXISTS UpdateInterval //
CREATE TRIGGER UpdateInterval
    BEFORE UPDATE
    ON `meteostation`.`data` FOR EACH ROW
BEGIN
    IF(NOT EXISTS(
            SELECT id FROM `meteostation`.`interval_of_updates`
            WHERE id = NEW.interval_of_updates_id
        ))
    THEN SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Error! No interval with such id';
    END IF;
END //
DELIMITER ;

DELIMITER //
DROP TRIGGER IF EXISTS UpdateIntervalId //
CREATE TRIGGER UpdateIntervalId
    BEFORE UPDATE
    ON `meteostation`.`interval_of_updates` FOR EACH ROW
BEGIN
    IF(EXISTS(
            SELECT interval_of_updates_id FROM `meteostation`.`data`
            WHERE interval_of_updates_id = OLD.id
        ))
    THEN SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Error! Can`t update row! FK';
    END IF;
END //
DELIMITER ;

DELIMITER //
DROP TRIGGER IF EXISTS DeleteAdressId //
CREATE TRIGGER DeleteAdressId
    BEFORE DELETE
    ON `meteostation`.`interval_of_updates` FOR EACH ROW
BEGIN
    IF(EXISTS(
            SELECT interval_of_updates_id FROM `meteostation`.`data`
            WHERE interval_of_updates_id = OLD.id
        ))
    THEN SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Error! Can`t delete row! FK';
    END IF;
END //
DELIMITER ;


DELIMITER //
DROP TRIGGER IF EXISTS CheckPhoneCardinality //
CREATE TRIGGER CheckPhoneCardinality
    BEFORE INSERT
    ON `meteostation`.`developer` FOR EACH ROW
BEGIN
    IF (LENGTH(NEW.telephone_num) < 10)
    THEN SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Phone can`t be less 10 sybmols';
    END IF;
END //
DELIMITER ;


DELIMITER //
DROP TRIGGER IF EXISTS only_names_accepted_in_developers_insertion;
CREATE TRIGGER only_names_accepted_in_developers_insertion
    BEFORE INSERT
    ON `meteostation`.`developer` FOR EACH ROW
BEGIN
    IF NEW.name NOT IN ('Svitlana', 'Petro', 'Olha', 'Taras') THEN
        SIGNAL SQLSTATE '22000'
            SET MESSAGE_TEXT = 'ONLY Svitlana, Petro, Olha, Taras can be delivery persons';
    END IF;
END //
DELIMITER ;

DROP TRIGGER IF EXISTS restrict_modification_of_company_table;
DELIMITER //
CREATE TRIGGER restrict_modification_of_company_table
    BEFORE UPDATE
    ON `meteostation`.`developer` FOR EACH ROW
BEGIN
    SIGNAL SQLSTATE '22000'
        SET MESSAGE_TEXT = 'You can not update this table.';
END //
DELIMITER ;