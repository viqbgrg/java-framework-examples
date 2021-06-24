DROP TABLE IF EXISTS user;
CREATE TABLE user
(
    id        BIGINT(20)  NOT NULL COMMENT '主键ID',
    user_name varchar(30) default null comment '用户名',
    email     varchar(30) not null comment '邮箱',
    password  varchar(92) not null comment '密码',
    locked    bool        default false,
    PRIMARY KEY (id)
);

create table roles
(
    id          bigint auto_increment,
    role        varchar(100),
    description varchar(100),
    available   bool default false,
    constraint pk_roles primary key (id)
);
create unique index idx_roles_role on roles (role);

create table permissions
(
    id          bigint auto_increment,
    permission  varchar(100),
    description varchar(100),
    available   bool default false,
    constraint pk_permissions primary key (id)
);
create unique index idx_permissions_permission on permissions (permission);

create table users_roles
(
    user_id bigint,
    role_id bigint,
    constraint pk_users_roles primary key (user_id, role_id)
);

create table roles_permissions
(
    role_id       bigint,
    permission_id bigint,
    constraint pk_roles_permissions primary key (role_id, permission_id)
);