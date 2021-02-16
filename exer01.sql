-- MySQL Script generated by MySQL Workbench
-- seg 15 fev 2021 21:50:42
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema db_generation_game_online
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema db_generation_game_online
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `db_generation_game_online` ;
USE `db_generation_game_online` ;

-- -----------------------------------------------------
-- Table `db_generation_game_online`.`tb_classe`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_generation_game_online`.`tb_classe` (
  `id_classe` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `cargo` VARCHAR(45) NULL,
  `salario` DOUBLE NULL,
  `setor` VARCHAR(45) NULL,
  PRIMARY KEY (`id_classe`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_generation_game_online`.`tb_personagem`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_generation_game_online`.`tb_personagem` (
  `id_per` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `funcionario` VARCHAR(45) NULL,
  `nome` VARCHAR(45) NULL,
  `arma` VARCHAR(45) NULL,
  `poder_ataque` BIGINT(10000) NULL,
  `poder_defesa` BIGINT(10000) NULL,
  `fk_id_classe` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id_per`, `fk_id_classe`),
  INDEX `fk_tb_personagem_tb_classe_idx` (`fk_id_classe` ASC) VISIBLE,
  CONSTRAINT `fk_tb_personagem_tb_classe`
    FOREIGN KEY (`fk_id_classe`)
    REFERENCES `db_generation_game_online`.`tb_classe` (`id_classe`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

INSERT INTO db_generation_game_online.tb_classe (cargo)
VALUES
("administrativo"),
("programadora"),
("faxineira"),
("designer"),
("ajudante");


INSERT INTO db_generation_game_online.tb_classe (salario)
VALUES
(2000),
(1000),
(3000),
(2500),
(3000);


INSERT INTO db_generation_game_online.tb_classe (setor)
VALUES
("adm"),
("criacao"),
("limpeza"),
("criativo"),
("estagiario");

INSERT INTO db_generation_game_online.tb_personagem (funcionario)
VALUES
("leonardo"),
("caio"),
("diego"),
("lucas"),
("vitor");
INSERT INTO db_generation_game_online.tb_personagem (nome)
VALUES
("arqueiro"),
("arqueiro"),
("soldado"),
("soldado"),
("camago");
INSERT INTO db_generation_game_online.tb_personagem (arma)
VALUES
("arco"),
("arco"),
("espada"),
("espada"),
("vara");

select * from tb_personagem
where funcionario > 2000;

select * from tb_personagem
where funcionario between 1000 and 2000;

select * from tb_personagem
where funcionario like 'c%';

select * from
tb_classe inner join tb_personagem on(tb_classe.id_classe = tb_personagem.id_personagem);

select* from tb_personagem
where personagem = "arqueiro"; 
