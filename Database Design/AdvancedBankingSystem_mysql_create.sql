CREATE TABLE `User` (
	`id` bigint NOT NULL AUTO_INCREMENT,
	`name` varchar(50) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Executive` (
	`id` bigint NOT NULL AUTO_INCREMENT,
	`password` varchar(50) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Counter` (
	`id` bigint NOT NULL AUTO_INCREMENT,
	`cNumber` bigint NOT NULL AUTO_INCREMENT,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Service` (
	`id` bigint NOT NULL AUTO_INCREMENT,
	`serviceName` varchar(255) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `m2m` (
	`executiveID` bigint NOT NULL,
	`serviceID` bigint NOT NULL
);

CREATE TABLE `Token` (
	`number` bigint NOT NULL AUTO_INCREMENT,
	`serviceId` bigint NOT NULL,
	`counterId` bigint,
	PRIMARY KEY (`number`)
);

ALTER TABLE `m2m` ADD CONSTRAINT `m2m_fk0` FOREIGN KEY (`executiveID`) REFERENCES `Executive`(`id`);

ALTER TABLE `m2m` ADD CONSTRAINT `m2m_fk1` FOREIGN KEY (`serviceID`) REFERENCES `Service`(`id`);

ALTER TABLE `Token` ADD CONSTRAINT `Token_fk0` FOREIGN KEY (`serviceId`) REFERENCES `Service`(`id`);

ALTER TABLE `Token` ADD CONSTRAINT `Token_fk1` FOREIGN KEY (`counterId`) REFERENCES `Counter`(`id`);







