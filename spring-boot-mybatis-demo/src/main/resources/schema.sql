drop table if exists user;

create table user(
    id int AUTO_INCREMENT,
    name  varchar,
    income json COMMENT '今年每个月的收入',
    PRIMARY KEY (id)
)