drop table if exists user;
create table user
(
    id        BIGINT(20)   not null auto_increment comment '主键ID',
    username  VARCHAR(30)  null default null comment '姓名',
    email     VARCHAR(50)  null default null comment '邮箱',
    password  varchar(100) not null comment '密码',
    locked    tinyint(1)        default 0 comment '用户是否锁定',
    create_at timestamp    not null comment '用户创建时间',
    update_at timestamp    null default null on update current_timestamp comment '更新时间',
    primary key (id)
);

drop table if exists key_id;
create table key_id
(
    id VARCHAR(35) not null comment '主键ID',
    primary key (id)
);

drop table if exists sequence_id;
create table sequence_id
(
    id   BIGINT(20)  not null comment '主键ID',
    name VARCHAR(30) null default null comment '姓名',
    primary key (id)
);
create
sequence key_generator_model_seq start
with 1 increment by 1;


drop table if exists generator_id;
create table generator_id
(
    id BIGINT(20) not null comment '主键ID',
    primary key (id)
);

drop table if exists student;
create table student
(
    id   BIGINT(20) not null comment '主键ID',
    name varchar(20) comment '姓名',
    primary key (id)
);
drop table if exists book;
create table book
(
    id   BIGINT(20)  not null comment '主键ID',
    name varchar(20) not null comment '书名',
    primary key (id)
);
drop table if exists student_book;
create table student_book
(
    student_id BIGINT(20) not null comment '学生ID',
    book_id    BIGINT(20) not null comment '书id'
);

drop table if exists enum_test;
create table enum_test
(
    status int(11)     default null comment '项目状态',
    type   varchar(11) default null comment '项目类型'
);