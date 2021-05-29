DROP TABLE IF EXISTS user_json;
CREATE TABLE user_json
(
    id   BIGINT(20)  NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    name VARCHAR(30) NULL DEFAULT NULL COMMENT '姓名',
--     book_names  json NOT NULL COMMENT '用户id',
    PRIMARY KEY (id)
);