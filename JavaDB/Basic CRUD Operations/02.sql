CREATE DATABASE `minions`;
USE `minions`;

#01 >>>
CREATE TABLE `minions`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR (50) NOT NULL,
`age` INT
);

CREATE TABLE `towns` (
`town_id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR (30) NOT NULL
);

#02 >>>
ALTER TABLE `minions`
ADD COLUMN `town_id` INT,
ADD CONSTRAINT fk_minions_towns
FOREIGN KEY (`town_id`) REFERENCES `towns`(`id`);

#03 >>>
INSERT INTO `towns` 
VALUES 
(1, 'Sofia'),
(2, 'PLovdiv'),
(3 , 'Varna');

INSERT INTO `minions` 
VALUES
(1, 'Kevin', 22, 1 ),
(2, 'Bob',15, 3 ),
(3, 'Stewart', NULL, 2);

#04 >>>
TRUNCATE `minions`;

#05 >>>
DROP TABLE `minions`;
DROP TABLE `towns`;

#06 >>>
CREATE TABLE `people`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(200) NOT NULL,
`picture` BLOB,
`height` FLOAT(5, 2),
`weight` FLOAT(5, 2),
`gender` CHAR(1) NOT NULL,
`birthdate` DATE NOT NULL,
`biography` TEXT
);
# DA SE DOVURSHI


#07 >>>
CREATE TABLE `users`(
`id` INT(63) AUTO_INCREMENT, 
`username` VARCHAR(30) UNIQUE NOT NULL,
`password` VARCHAR(26) UNIQUE NOT NULL,
`profile_picture` BLOB(900),
`last_login_time` DATETIME,
`is_deleted` BOOL
);

#08 >>>
ALTER TABLE `users`
DROP PRIMARY KEY ,
ADD CONSTRAINT pk_users 
PRIMARY KEY (`id`, `username`);


