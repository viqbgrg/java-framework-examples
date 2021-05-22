DROP TABLE IF EXISTS userBook;
CREATE TABLE userBook
(
    id        BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    username  VARCHAR(30) NULL DEFAULT NULL COMMENT '姓名',
    password  varchar(100) NOT NULL COMMENT '密码',
    locked    tinyint(1) default 0 comment '用户是否锁定',
    sex    tinyint(1) default 0 comment '性别',
    create_at timestamp    not null comment '用户创建时间',
    update_at timestamp null DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP comment '更新时间',
    PRIMARY KEY (id)
);