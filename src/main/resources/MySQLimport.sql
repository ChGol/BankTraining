CREATE DATABASE bank_training_security;

USE bank_training_security;

CREATE TABLE `accounts` (
  `id` int auto_increment,
  `number` varchar(26),
  `balance` bigint,
  PRIMARY KEY(`id`)
);

CREATE TABLE `authorities` (
  `username` varchar(45),
  `authority` varchar(45),
  PRIMARY KEY (`username`)
);

INSERT INTO `authorities` VALUES ('Kate','ROLE_ADMIN');

CREATE TABLE `users` (
  `username` varchar(45),
  `password` varchar(45),
  `enabled` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`username`)
);

INSERT INTO `users` VALUES ('Kate','9da1f8e0aecc9d868bad115129706a77',1);
