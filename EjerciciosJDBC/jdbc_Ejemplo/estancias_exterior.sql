-- MySQL Workbench Synchronization
-- Generated: 2022-12-03 20:19
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: User

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE SCHEMA IF NOT EXISTS `estancias_exterior` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE IF NOT EXISTS `estancias_exterior`.`clientes` (
  `id_cliente` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(50) NOT NULL,
  `calle` VARCHAR(50) NULL DEFAULT NULL,
  `numero` INT(11) NOT NULL,
  `codigo postal` VARCHAR(45) NULL DEFAULT NULL,
  `ciudad` VARCHAR(45) NOT NULL,
  `pais` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id_cliente`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `estancias_exterior`.`familias` (
  `id_familia` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `edad_minima` INT(11) NOT NULL,
  `edad maxima` INT(11) NOT NULL,
  `num_hijos` INT(11) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `id_casa_familia` INT(11) NOT NULL,
  PRIMARY KEY (`id_familia`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `estancias_exterior`.`casas` (
  `id_casas` INT(11) NOT NULL,
  `calle` VARCHAR(45) NULL DEFAULT NULL,
  `numero` INT(11) NOT NULL,
  `codigo_postal` VARCHAR(10) NULL DEFAULT NULL,
  `ciudad` VARCHAR(45) NOT NULL,
  `pais` VARCHAR(45) NOT NULL,
  `fecha_desde` DATE NOT NULL,
  `fecha_hasta` DATE NOT NULL,
  `tiempo_minimo` INT(11) NOT NULL,
  `tiempo_maximo` INT(11) NOT NULL,
  `precio_habitacion` DECIMAL(15,2) NOT NULL,
  `tipo_vivienda` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`id_casas`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '	';

CREATE TABLE IF NOT EXISTS `estancias_exterior`.`comentarios` (
  `id_comentario` INT(11) NOT NULL AUTO_INCREMENT,
  `id_casa` INT(11) NOT NULL,
  `comentario` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id_comentario`),
  INDEX `id_casa_idx` (`id_casa` ASC) VISIBLE,
  CONSTRAINT `id_casa`
    FOREIGN KEY (`id_casa`)
    REFERENCES `estancias_exterior`.`casas` (`id_casas`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `estancias_exterior`.`estancias` (
  `id_estancia` INT(11) NOT NULL AUTO_INCREMENT,
  `id_cliente` INT(11) NOT NULL,
  `id_casa` INT(11) NOT NULL,
  `nombre_huesped` VARCHAR(70) NOT NULL,
  `fecha_desde` DATE NOT NULL,
  `fecha_hasta` DATE NOT NULL,
  PRIMARY KEY (`id_estancia`),
  INDEX `id_cliente_idx` (`id_cliente` ASC) VISIBLE,
  INDEX `id_casa_idx` (`id_casa` ASC) VISIBLE,
  CONSTRAINT `id_cliente`
    FOREIGN KEY (`id_cliente`)
    REFERENCES `estancias_exterior`.`clientes` (`id_cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `id_casa`
    FOREIGN KEY (`id_casa`)
    REFERENCES `estancias_exterior`.`casas` (`id_casas`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
