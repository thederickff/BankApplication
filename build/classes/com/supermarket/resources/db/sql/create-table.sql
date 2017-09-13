CREATE TABLE `bmarket_store`.`products` ( 
`id` INT NOT NULL AUTO_INCREMENT , 
`name` VARCHAR(150) NOT NULL , 
`unit_price` DECIMAL NOT NULL , 
`description` TEXT NOT NULL , 
`manufacturer` VARCHAR(100) NOT NULL , 
`category` VARCHAR(100) NOT NULL , 
PRIMARY KEY (`id`)
) ENGINE = InnoDB;
