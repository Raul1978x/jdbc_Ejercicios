-- MySQL Workbench Synchronization
-- Generated: 2022-12-03 12:46
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: User

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE SCHEMA IF NOT EXISTS `perros` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE IF NOT EXISTS `perros`.`Usuario` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `correoElectronico` VARCHAR(45) NOT NULL,
  `clave` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `perros`.`Mascota` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `apodo` VARCHAR(45) NOT NULL,
  `raza` VARCHAR(45) NOT NULL,
  `idUsuario` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `id_usuario_idx` (`idUsuario` ASC) VISIBLE,
  CONSTRAINT `id_usuario`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `perros`.`Usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;