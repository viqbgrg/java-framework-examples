DROP TABLE IF EXISTS user;

CREATE TABLE user
(
    id          BIGINT (20) NOT NULL COMMENT '主键ID',
    name        VARCHAR(30) NULL DEFAULT NULL COMMENT '姓名',
    age         INT (11) NULL DEFAULT NULL COMMENT '年龄',
    email       VARCHAR(50) NULL DEFAULT NULL COMMENT '邮箱',
    version     INT(10) NULL DEFAULT 1 COMMENT '乐观锁版本',
    deleted     INT (11) NULL DEFAULT 1 COMMENT '逻辑删除字段',
    create_time TIMESTAMP NULL,
    PRIMARY KEY (id)
);