DROP TABLE IF EXISTS userBook;
CREATE TABLE userBook
(
    id       BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    username VARCHAR(30) NULL DEFAULT NULL COMMENT '姓名',
    role_id  BIGINT(20) NOT NULL COMMENT '用户id',
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS roles;
CREATE TABLE roles
(
    id        BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    role_name VARCHAR(30) NULL DEFAULT NULL COMMENT '权限',
    PRIMARY KEY (id)
);
