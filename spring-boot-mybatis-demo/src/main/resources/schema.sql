drop table if exists user;

CREATE TABLE `user` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `name` varchar(11) DEFAULT NULL,
    `income` text DEFAULT NULL,
    `car` text DEFAULT NULL,
    PRIMARY KEY (`id`)
)