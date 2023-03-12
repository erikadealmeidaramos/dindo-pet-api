-- MySQL Script generated by MySQL Workbench

-- Tue Mar  7 20:36:21 2023

-- Model: New Model    Version: 1.0

-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;

SET
    @OLD_FOREIGN_KEY_CHECKS = @ @FOREIGN_KEY_CHECKS,
    FOREIGN_KEY_CHECKS = 0;

SET
    @OLD_SQL_MODE = @ @SQL_MODE,
    SQL_MODE = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

SHOW WARNINGS;

USE `dindo-pet` ;

-- -----------------------------------------------------

-- Table `Breed`

-- -----------------------------------------------------

DROP TABLE IF EXISTS `Breed` ;

SHOW WARNINGS;

CREATE TABLE
    IF NOT EXISTS `Breed` (
        `idBreed` INT NOT NULL,
        `descriptionBreed` VARCHAR(80) NOT NULL,
        `Species_idSpecies` INT NOT NULL,
        PRIMARY KEY (`idBreed`)
    ) ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------

-- Table `Pet`

-- -----------------------------------------------------

SHOW WARNINGS;

CREATE TABLE
    IF NOT EXISTS `Pet` (
        `idPet` INT NOT NULL,
        `namePet` VARCHAR(45) NOT NULL,
        `picturePet` VARCHAR(200) NOT NULL,
        `status` TINYINT NOT NULL,
        `cash` FLOAT NOT NULL,
        `User_idUser` INT NOT NULL,
        `Breed_idBreed` INT NOT NULL,
        PRIMARY KEY (`idPet`)
    ) ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------

-- Table `Post`

-- -----------------------------------------------------

SHOW WARNINGS;

CREATE TABLE
    IF NOT EXISTS `Post` (
        `idPost` INT NOT NULL,
        `picturePost` VARCHAR(200) NULL,
        `paymentvoucher` TINYINT NOT NULL,
        `Pet_idPet` INT NOT NULL,
        PRIMARY KEY (`idPost`)
    ) ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------

-- Table `Species`

-- -----------------------------------------------------

SHOW WARNINGS;

CREATE TABLE
    IF NOT EXISTS `Species` (
        `idSpecies` INT NOT NULL,
        `descriptionSpecies` CHAR(1) NOT NULL,
        PRIMARY KEY (`idSpecies`)
    ) ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------

-- Table `User`

-- -----------------------------------------------------

SHOW WARNINGS;

CREATE TABLE
    IF NOT EXISTS `User` (
        `idUser` INT NOT NULL AUTO_INCREMENT,
        `nameUser` VARCHAR(200) NOT NULL,
        `email` VARCHAR(200) NOT NULL,
        `password` VARCHAR(20) NOT NULL,
        `cpf` VARCHAR(15) NOT NULL,
        `pix` VARCHAR(35) NOT NULL,
        PRIMARY KEY (`idUser`)
    ) ENGINE = InnoDB;

SHOW WARNINGS;

SET SQL_MODE=@OLD_SQL_MODE;

SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;

SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;