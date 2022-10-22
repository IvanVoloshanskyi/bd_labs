
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;
SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS `mydb`.`adress` ;
DROP TABLE IF EXISTS `mydb`.`data` ;
DROP TABLE IF EXISTS `mydb`.`developer` ;
DROP TABLE IF EXISTS `mydb`.`gps` ;
DROP TABLE IF EXISTS `mydb`.`interval_of_updates` ;
DROP TABLE IF EXISTS `mydb`.`meteostation` ;
DROP TABLE IF EXISTS `mydb`.`service_work` ;
DROP TABLE IF EXISTS `mydb`.`location` ;
SET FOREIGN_KEY_CHECKS=1;

-- -----------------------------------------------------
-- Table `mydb`.`interval_of_updates`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`interval_of_updates` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `interval` INT NOT NULL,
  CONSTRAINT interval_of_updates_pk PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`data`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`data` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `temperature` INT NOT NULL,
  `humidity` INT NOT NULL,
  `wind_speed` INT NOT NULL,
  `atmospheric_pressure` INT NOT NULL,
  `wind_direction` VARCHAR(15) NOT NULL,
  `interval_of_updates_id` INT NOT NULL,
  CONSTRAINT data_pk PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`adress`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`adress` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `adress` VARCHAR(45) NOT NULL,
  `street` VARCHAR(45) NULL,
  `build` VARCHAR(45) NULL,
  CONSTRAINT adress_pk PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`gps`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`gps` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `latitude` VARCHAR(45) NOT NULL,
  `longtitude` VARCHAR(45) NOT NULL,
  CONSTRAINT gps_pk PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`location`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`location` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `city` VARCHAR(45) NOT NULL,
  `adress_id` INT NOT NULL,
  `gps_id` INT NOT NULL,
  CONSTRAINT location_pk PRIMARY KEY (`id`))
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`service_work`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`service_work` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `date` DATE NOT NULL,
  `description` VARCHAR(50) NOT NULL,
  CONSTRAINT service_work_pk PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`developer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`developer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `telephone_num` VARCHAR(45) NULL,
  CONSTRAINT developer_pk PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`meteostation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`meteostation` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `installation_date` DATE NOT NULL,
  `data_id` INT NOT NULL,
  `interval_of_updates_id` INT NOT NULL,
  `location_id` INT NOT NULL,
  `service_work_id` INT NOT NULL,
  `developer_id` INT NOT NULL,
  CONSTRAINT meteostation_pk PRIMARY KEY (`id`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `ІНДЕКСИ`
-- -----------------------------------------------------
CREATE UNIQUE INDEX developer_tel_num_index ON developer(`telephone_num`);   -- Номер телефону повинен бути унікальним    
CREATE UNIQUE INDEX  location_city_index ON location(`city`);  -- Місто також повинно бути унікальним
CREATE UNIQUE INDEX adress_street_id ON adress(`street`); --  унікальна вулиця
-- -----------------------------------------------------
-- Table `ІНДЕКСИ`
-- -----------------------------------------------------

ALTER TABLE meteostation ADD CONSTRAINT meteostation_data_id FOREIGN KEY meteostation_data_id(data_id)
    REFERENCES data(id);
    
ALTER TABLE meteostation ADD CONSTRAINT meteostation_interval_of_updates_id FOREIGN KEY meteostation_interval_of_updates_id(interval_of_updates_id)
    REFERENCES interval_of_updates(id);
    
ALTER TABLE meteostation ADD CONSTRAINT meteostation_location_id FOREIGN KEY meteostation_location_id(location_id)
    REFERENCES location(id);
    
ALTER TABLE meteostation ADD CONSTRAINT meteostation_service_work_id FOREIGN KEY meteostation_service_work_id(service_work_id)
    REFERENCES service_work(id);
    
ALTER TABLE meteostation ADD CONSTRAINT data FOREIGN KEY meteostation_developer_id(developer_id)
	REFERENCES developer(id);
    
ALTER TABLE `data` ADD CONSTRAINT data_interval_of_updates_id FOREIGN KEY data_interval_of_updates_id(interval_of_updates_id)
	REFERENCES interval_of_updates(id);
-- 14:34:04	INSERT INTO data (`id`,`temperature`,`humidity`, `wind_speed`, `atmospheric_pressure`, `wind_direction`,  `interval_of_updates_id`) VALUES ("1", "1", "1", "1", "1","1","1"),      ("2", "2", "2", "2", "2","2","2"),      ("3", "3", "3", "3", "3","3","3"),      ("4", "4", "4", "4", "4","4","4"),      ("5", "5", "5", "5", "5","5","5"),      ("6", "6", "6", "6", "6","6","6"),      ("7", "7", "7", "7", "7","7","7"),      ("8", "8", "8", "8", "8","8","8"),      ("9", "9", "9", "9", "9","9","9"),      ("10", "10", "10", "10", "10","10","10")	Error Code: 1452. Cannot add or update a child row: a foreign key constraint fails (`mydb`.`data`, CONSTRAINT `data_interval_of_updates_id` FOREIGN KEY (`interval_of_updates_id`) REFERENCES `interval_of_updates` (`id`))	0.063 sec

ALTER TABLE location ADD CONSTRAINT location_adress_id FOREIGN KEY location_adress_id(adress_id)
	REFERENCES adress(id);

ALTER TABLE location ADD CONSTRAINT location_gps_id FOREIGN KEY location_gps_id(gps_id)
	REFERENCES gps(id);
    
INSERT INTO interval_of_updates (`id`, `interval`) VALUES
("1", "1"),     
("2", "2"),     
("3", "3"),     
("4", "4"),     
("5", "5"),     
("6", "6"),     
("7", "7"),     
("8", "8"),     
("9", "9"),     
("10", "10");       

INSERT INTO adress (`id`,`adress`,`street`,`build` ) VALUES
("1", "None", "Kopernika 1", "SC Vesna"),     
("2", "None", "Kopernika 2", "SC Vesna"),     
("3", "None", "Kopernika 3", "SC Vesna"),     
("4", "None", "Kopernika 4", "SC Vesna"),     
("5", "None", "Kopernika 5", "SC Vesna"),     
("6", "None", "Kopernika 6", "SC Vesna"),     
("7", "None", "Kopernika 7", "SC Vesna"),     
("8", "None", "Kopernika 8", "SC Vesna"),     
("9", "None", "Kopernika 9", "SC Vesna"),    
("10", "None", "Kopernika 10", "SC Vesna");     
    
INSERT INTO data (`id`,`temperature`,`humidity`, `wind_speed`, `atmospheric_pressure`, `wind_direction`,  `interval_of_updates_id`) VALUES
("1", "1", "1", "1", "1","1","1"),     
("2", "2", "2", "2", "2","2","2"),     
("3", "3", "3", "3", "3","3","3"),     
("4", "4", "4", "4", "4","4","4"),     
("5", "5", "5", "5", "5","5","5"),     
("6", "6", "6", "6", "6","6","6"),     
("7", "7", "7", "7", "7","7","7"),     
("8", "8", "8", "8", "8","8","8"),     
("9", "9", "9", "9", "9","9","9"),     
("10", "10", "10", "10", "10","10","10");    
       
INSERT INTO developer (`id`,`name`,`surname`,`telephone_num`) VALUES
("1", "Ivan", "Voloshanskyi", "0980000001"),     
("2", "Taras", "Tovarnitskyi", "0980000002"),     
("3", "Taras", "Florko", "0980000003"),     
("4", "Maryan", "Petlovaniy", "0980000004"),     
("5", "Taras", "Shewchenko", "0980000005"),     
("6", "Oleh", "Vynnyk", "0980000006"),     
("7", "Stapan", "Giga", "0980000007"),     
("8", "Olga", "Polyakova", "0980000008"),     
("9", "Biba", "Boba", "0980000009"),     
("10", "Derevo", "Dyb", "0980000000");       


INSERT INTO gps (`id`,`latitude`,`longtitude`) VALUES
("1", "1", "1"),     
("2", "2", "2"),     
("3", "3", "3"),     
("4", "4", "4"),     
("5", "5", "5"),     
("6", "6", "6"),     
("7", "7", "7"),     
("8", "8", "8"),     
("9", "9", "9"),     
("10", "10", "10");  

INSERT INTO location (`city`,`adress_id`,`gps_id`) VALUES
("Sambir", "1", "1"),     
("Lviv", "2", "2"),     
("Drohobych", "3", "3"),     
("Ivano-Frankivsk", "4", "4"),     
("Rivne", "5", "5"),     
("Ralivka", "6", "6"),     
("Rydku", "7", "7"),     
("Suhiv", "8", "8"),     
("St-Sambir", "9", "9"),     
("Biskovuchi", "10", "10");  
     
     

INSERT INTO service_work (`id`,`date`,`description`) VALUES
("1", "2000-10-01", "Removed meteostation"),     
("2", "2000-10-02", "Fixed errors"),     
("3", "2000-10-03", "IDK"),     
("4", "2000-10-04", "Has anybody read this?"),     
("5", "2000-10-05", "Meteostation exploded"),     
("6", "2000-10-06", "None"),     
("7", "2000-10-07", "Clear like a baby"),     
("8", "2000-10-08", "None also"),     
("9", "2000-10-09", "Almost exploded"),     
("10", "2000-10-10", "Not exploded");  
     
INSERT INTO meteostation (`id`,`installation_date`, `data_id`, `interval_of_updates_id`, `location_id`, `service_work_id`, `developer_id` ) VALUES
("1", "2000-10-01", "1", "1", "1", "1", "1"),     
("2", "2000-10-02", "2", "2", "2", "2", "2"),     
("3", "2000-10-03", "3", "3", "3", "3", "3"),     
("4", "2000-10-04", "4", "4", "4", "4", "4"),     
("5", "2000-10-05", "5", "5", "5", "5", "5"),     
("6", "2000-10-06", "6", "6", "6", "6", "6"),     
("7", "2000-10-07", "7", "7", "7", "7", "7"),     
("8", "2000-10-08", "8", "8", "8", "8", "8"),     
("9", "2000-10-09", "9", "9", "9", "9", "9"),     
("10", "2000-10-10", "10", "10", "10", "10", "10");   



