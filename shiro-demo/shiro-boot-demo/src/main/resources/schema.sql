DROP TABLE IF EXISTS user;
CREATE TABLE user
(
    id   BIGINT(20) NOT NULL COMMENT '主键ID',
    user_name varchar(30) default null comment '用户名',
    email varchar(30) not null comment '邮箱',
    password varchar(50) not null comment '密码',
    PRIMARY KEY (id)
);