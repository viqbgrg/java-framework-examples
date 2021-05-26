DROP TABLE IF EXISTS book;
CREATE TABLE book
(
    id   BIGINT(20)  NOT NULL COMMENT '主键ID',
    name varchar(20) not null comment '书名',
    PRIMARY KEY (id)
);