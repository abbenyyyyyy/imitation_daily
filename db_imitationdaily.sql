-- MySQL Script generated by MySQL Workbench
-- Thu Mar  8 16:40:54 2018
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema db_imitationdaily
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema db_imitationdaily
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `db_imitationdaily` DEFAULT CHARACTER SET utf8 ;
USE `db_imitationdaily` ;

-- -----------------------------------------------------
-- Table `db_imitationdaily`.`news`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_imitationdaily`.`news` (
  `id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '新闻的id',
  `title` VARCHAR(45) NULL COMMENT '新闻标题',
  `likes` BIGINT(20) UNSIGNED NULL DEFAULT 0,
  `create_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `img_url` VARCHAR(45) NULL COMMENT '新闻封面的url',
  `content` TEXT NULL COMMENT '新闻详情内容',
  `news_category_id` BIGINT(20) UNSIGNED NOT NULL COMMENT '新闻类别id',
  `status_id` BIGINT(20) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_imitationdaily`.`news_category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_imitationdaily`.`news_category` (
  `category_id` BIGINT(20) UNSIGNED NOT NULL COMMENT '新闻类别id',
  `category_name` VARCHAR(45) NOT NULL COMMENT '新闻类别名字',
  PRIMARY KEY (`category_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_imitationdaily`.`message`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_imitationdaily`.`message` (
  `message_id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `news_id` BIGINT(20) UNSIGNED NOT NULL COMMENT '对应新闻id',
  `user_id` BIGINT(20) UNSIGNED NOT NULL COMMENT '留言者id',
  `pid` BIGINT(20) UNSIGNED NULL COMMENT '父留言id',
  `content` VARCHAR(255) NULL COMMENT '留言内容',
  `create_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `likes` BIGINT(20) UNSIGNED NULL DEFAULT 0,
  `status_id` BIGINT(20) UNSIGNED NOT NULL,
  PRIMARY KEY (`message_id`));


-- -----------------------------------------------------
-- Table `db_imitationdaily`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_imitationdaily`.`user` (
  `user_id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(16) NOT NULL,
  `email` VARCHAR(255) NULL,
  `password` VARCHAR(32) NOT NULL,
  `create_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `user_rank_id` BIGINT(20) UNSIGNED NOT NULL,
  `status_id` BIGINT(20) UNSIGNED NOT NULL,
  PRIMARY KEY (`user_id`));


-- -----------------------------------------------------
-- Table `db_imitationdaily`.`user_rank`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_imitationdaily`.`user_rank` (
  `rank_id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `rank_name` VARCHAR(45) NULL COMMENT '权限名称',
  PRIMARY KEY (`rank_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_imitationdaily`.`status`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_imitationdaily`.`status` (
  `status_id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `status_name` VARCHAR(45) NULL,
  PRIMARY KEY (`status_id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;