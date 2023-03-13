USE `dindo-pet` ;

-- -----------------------------------------------------

-- Table `Breed`

-- -----------------------------------------------------

CREATE TABLE
    IF NOT EXISTS `Breed` (
        `idBreed` INT NOT NULL,
        `descriptionBreed` VARCHAR(80) NOT NULL,
        `Species_idSpecies` INT NOT NULL,
        PRIMARY KEY (`idBreed`)
    ) ENGINE = InnoDB;

-- -----------------------------------------------------

-- Table `Pet`

-- -----------------------------------------------------

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

-- -----------------------------------------------------

-- Table `Post`

-- -----------------------------------------------------

CREATE TABLE
    IF NOT EXISTS `Post` (
        `idPost` INT NOT NULL,
        `picturePost` VARCHAR(200) NULL,
        `paymentvoucher` TINYINT NOT NULL,
        `Pet_idPet` INT NOT NULL,
        PRIMARY KEY (`idPost`)
    ) ENGINE = InnoDB;

-- -----------------------------------------------------

-- Table `Species`

-- -----------------------------------------------------

CREATE TABLE
    IF NOT EXISTS `Species` (
        `idSpecies` INT NOT NULL,
        `descriptionSpecies` CHAR(1) NOT NULL,
        PRIMARY KEY (`idSpecies`)
    ) ENGINE = InnoDB;

-- -----------------------------------------------------

-- Table `User`

-- -----------------------------------------------------

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