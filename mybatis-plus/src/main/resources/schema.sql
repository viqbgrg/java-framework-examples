DROP TABLE IF EXISTS user;
CREATE TABLE user
(
    id        BIGINT(20)   NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    username  VARCHAR(30)  NULL DEFAULT NULL COMMENT '姓名',
    email     VARCHAR(50)  NULL DEFAULT NULL COMMENT '邮箱',
    password  varchar(100) NOT NULL COMMENT '密码',
    locked    tinyint(1)        default 0 comment '用户是否锁定',
    create_at timestamp    not null comment '用户创建时间',
    update_at timestamp    null DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP comment '更新时间',
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS key_id;
CREATE TABLE key_id
(
    id VARCHAR(35) NOT NULL COMMENT '主键ID',
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS sequence_id;
CREATE TABLE sequence_id
(
    id   BIGINT(20)  NOT NULL COMMENT '主键ID',
    name VARCHAR(30) NULL DEFAULT NULL COMMENT '姓名',
    PRIMARY KEY (id)
);
CREATE SEQUENCE key_generator_model_seq START WITH 1 INCREMENT BY 1;