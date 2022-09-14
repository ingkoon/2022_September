-- CREATE SCHEMA `sindoboard` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci ;

use sindoboard;
CREATE TABLE IF NOT EXISTS `sinuser` (
  `id` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `pwd` VARCHAR(45) NOT NULL,
  `addr` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`));
CREATE TABLE IF NOT EXISTS `sinboard` (
  `ids` INT NOT NULL AUTO_INCREMENT,
  `writer` VARCHAR(45) NOT NULL,
  `title` VARCHAR(200) NOT NULL,
  `content` VARCHAR(1000) NOT NULL,
  `wdate` DATE NOT NULL,
  PRIMARY KEY (`ids`),
  CONSTRAINT `fk_sinboard_sinuser`
    FOREIGN KEY (`writer`)
    REFERENCES `sinuser` (`id`));

insert into sinuser(id,name,pwd,addr) values
('sindo','신도','1234','서울 강동구'),
('injae','인재','2345','수원 팔달구'),
('minso','민소','1234','서울 서초구');
commit;

select * from sinboard order by ids;