-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Usuarios` (
  `idUsuario` INT NOT NULL AUTO_INCREMENT,
  `usNombre` VARCHAR(45) NOT NULL,
  `usPassword` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idUsuario`)
) ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `mydb`.`Noticias`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Noticias` (
  `idNoticia` INT NOT NULL AUTO_INCREMENT,
  `noTitulo` VARCHAR(45) NOT NULL,
  `noContenido` LONGTEXT NOT NULL,
  `fk_autor` INT NOT NULL,
  PRIMARY KEY (`idNoticia`),
  INDEX `fk_Noticias_Usuarios_idx` (`fk_autor` ASC),
  CONSTRAINT `fk_Noticias_Usuarios`
    FOREIGN KEY (`fk_autor`)
    REFERENCES `mydb`.`Usuarios` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
) ENGINE = InnoDB;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
