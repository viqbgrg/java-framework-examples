CREATE USER IF NOT EXISTS GUEST PASSWORD 'abc';
GRANT SELECT ON SCHEMA PUBLIC TO GUEST;

drop table if exists user;

CREATE TABLE `user`
(
    `id`     int(11) NOT NULL AUTO_INCREMENT,
    `name`   varchar(11) DEFAULT NULL,
    `income` json        DEFAULT NULL,
    `car`    json        DEFAULT NULL,
    PRIMARY KEY (`id`)
)