-- MySQL Script generated by MySQL Workbench
-- Sáb 05 Ago 2017 16:36:42 BRT
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema usernamedb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `usernamedb` ;

-- -----------------------------------------------------
-- Schema usernamedb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `usernamedb` DEFAULT CHARACTER SET utf8 ;
USE `usernamedb` ;

-- -----------------------------------------------------
-- Table `usernamedb`.`persona`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `usernamedb`.`persona` ;

CREATE TABLE IF NOT EXISTS `usernamedb`.`persona` (
  `id` VARCHAR(128) NOT NULL,
  `first_name` VARCHAR(20) NULL DEFAULT NULL,
  `last_name` VARCHAR(35) NULL DEFAULT NULL,
  `email` VARCHAR(35) NULL DEFAULT NULL,
  `verified` TINYINT(4) NULL DEFAULT NULL,
  `status` VARCHAR(15) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `usernamedb`.`credential`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `usernamedb`.`credential` ;

CREATE TABLE IF NOT EXISTS `usernamedb`.`credential` (
  `id` VARCHAR(128) NOT NULL,
  `principal` VARCHAR(45) NULL DEFAULT NULL,
  `credential` VARCHAR(20) NULL DEFAULT NULL,
  `changed` TINYINT NULL,
  `attempt` INT NULL,
  `number_attempt` INT NULL,
  `persona` VARCHAR(128) NOT NULL,
  PRIMARY KEY (`id`, `persona`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `fk_Credential_Persona1_idx` ON `usernamedb`.`credential` (`persona` ASC);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
