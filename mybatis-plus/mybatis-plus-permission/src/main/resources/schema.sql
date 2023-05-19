drop table if exists student;
create table student
(
    id       BIGINT(20) not null comment '主键ID',
    name     varchar(20) comment '姓名',
    class_id BIGINT(20) comment '班级id',
    grade  BIGINT(20) comment '年级',
    primary key (id)
);

drop table if exists t_class;
create table t_class
(
    id         bigint(20) not null,
    class_name varchar(20),
    primary key (id)
)
