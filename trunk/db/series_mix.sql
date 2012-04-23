SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `series_mix` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `series_mix` ;

-- -----------------------------------------------------
-- Table `series_mix`.`Serie`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `series_mix`.`Serie` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT 'Identificação' ,
  `Nome` VARCHAR(100) NOT NULL COMMENT 'Nome' ,
  `Sinopse` TEXT NOT NULL COMMENT 'Sinopse' ,
  `Duracao` TIME NOT NULL COMMENT 'Duração' ,
  `Situacao` VARCHAR(50) NOT NULL COMMENT 'Situação' ,
  `Lancamento` DATE NOT NULL COMMENT 'Data de Lançamento' ,
  `Cancelamento` DATE NULL DEFAULT NULL COMMENT 'Data de Cancelamento' ,
  PRIMARY KEY (`id`) );


-- -----------------------------------------------------
-- Table `series_mix`.`Temporada`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `series_mix`.`Temporada` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT 'Identificação' ,
  `Serie` BIGINT NOT NULL COMMENT 'Série' ,
  `Numero` INT NOT NULL COMMENT 'Número' ,
  `Capa` BLOB NULL DEFAULT NULL COMMENT 'Capa (Somente JPEG)' ,
  `Trailer` VARCHAR(350) NULL DEFAULT NULL COMMENT 'Trailer' ,
  `Final` BIT NOT NULL COMMENT 'Temporada Final? 0 - Não ; 1 - Sim' ,
  PRIMARY KEY (`id`) ,
  INDEX `FK_SERIE_TEMPORADA` (`Serie` ASC) ,
  CONSTRAINT `FK_SERIE_TEMPORADA`
    FOREIGN KEY (`Serie` )
    REFERENCES `series_mix`.`Serie` (`id` )
    ON DELETE RESTRICT
    ON UPDATE CASCADE);


-- -----------------------------------------------------
-- Table `series_mix`.`Episodio`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `series_mix`.`Episodio` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT 'Identificação' ,
  `Temporada` BIGINT NOT NULL COMMENT 'Temporada' ,
  `Numero` INT NOT NULL COMMENT 'Número' ,
  `Nome` VARCHAR(100) NOT NULL COMMENT 'Nome' ,
  `Lancamento` DATE NOT NULL COMMENT 'Data de Lançamento' ,
  `Postagem` DATETIME NOT NULL COMMENT 'Data de Postagem' ,
  `Visita` BIGINT NULL DEFAULT 0 COMMENT 'Quantidade de visitas' ,
  PRIMARY KEY (`id`) ,
  INDEX `FK_TEMPORADA_EPISODIO` (`Temporada` ASC) ,
  CONSTRAINT `FK_TEMPORADA_EPISODIO`
    FOREIGN KEY (`Temporada` )
    REFERENCES `series_mix`.`Temporada` (`id` )
    ON DELETE RESTRICT
    ON UPDATE CASCADE);


-- -----------------------------------------------------
-- Table `series_mix`.`Usuario`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `series_mix`.`Usuario` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT 'Identificação' ,
  `Nome` VARCHAR(100) NOT NULL COMMENT 'Nome' ,
  `Email` VARCHAR(121) NOT NULL COMMENT 'E-mail' ,
  `Senha` VARCHAR(50) NOT NULL COMMENT 'Senha' ,
  `Nivel` INT NOT NULL COMMENT 'Nível: 0 -  Administrador; 1 - Usuário; 2 - Visitante' ,
  `Cadastro` DATE NOT NULL COMMENT 'Data de Cadastro' ,
  PRIMARY KEY (`id`) );


-- -----------------------------------------------------
-- Table `series_mix`.`Comentario`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `series_mix`.`Comentario` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT 'Identificação' ,
  `Temporada` BIGINT NOT NULL COMMENT 'Temporada' ,
  `Usuario` BIGINT NOT NULL COMMENT 'Usuário' ,
  `Episodio` BIGINT NOT NULL COMMENT 'Episódio' ,
  `Mensagem` TEXT NOT NULL COMMENT 'Mensagem' ,
  `Postagem` DATETIME NOT NULL COMMENT 'Data de Postagem' ,
  PRIMARY KEY (`id`) ,
  INDEX `FK_EPISODIO_COMENTARIO` (`Episodio` ASC) ,
  INDEX `FK_TEMPORADA_COMENTARIO` (`Temporada` ASC) ,
  INDEX `FK_USUARIO_COMENTARIO` (`Usuario` ASC) ,
  CONSTRAINT `FK_EPISODIO_COMENTARIO`
    FOREIGN KEY (`Episodio` )
    REFERENCES `series_mix`.`Episodio` (`id` )
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `FK_TEMPORADA_COMENTARIO`
    FOREIGN KEY (`Temporada` )
    REFERENCES `series_mix`.`Temporada` (`id` )
    ON DELETE restrict
    ON UPDATE restrict,
  CONSTRAINT `FK_USUARIO_COMENTARIO`
    FOREIGN KEY (`Usuario` )
    REFERENCES `series_mix`.`Usuario` (`id` )
    ON DELETE restrict
    ON UPDATE restrict);


-- -----------------------------------------------------
-- Table `series_mix`.`Servidor`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `series_mix`.`Servidor` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT 'Identificação' ,
  `Episodio` BIGINT NOT NULL COMMENT 'Episódio' ,
  `Nome` VARCHAR(100) NOT NULL COMMENT 'Nome' ,
  `Endereco` VARCHAR(350) NOT NULL COMMENT 'Endereço' ,
  `Situacao` VARCHAR(10) NOT NULL COMMENT 'Situação' ,
  PRIMARY KEY (`id`) ,
  INDEX `FK_EPISODIO_SERVIDOR` (`Episodio` ASC) ,
  CONSTRAINT `FK_EPISODIO_SERVIDOR`
    FOREIGN KEY (`Episodio` )
    REFERENCES `series_mix`.`Episodio` (`id` )
    ON DELETE RESTRICT
    ON UPDATE CASCADE);



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
