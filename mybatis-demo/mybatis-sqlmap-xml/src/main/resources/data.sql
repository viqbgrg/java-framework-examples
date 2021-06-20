INSERT INTO `user_book`(`id`, `name`, `tag`)
VALUES (1, '三国演义', '名著'),
       (1, '西游记', '名著'),
       (2, '红楼梦', '名著'),
       (3, 'Java 核心思想', '技术');

insert into `user`(`id`,`name`)
values ( 1, '小明' ),
       (2,'张三');

insert into `book`(`id`,`book_name`)
values ( 1, '三国演义' ),
       (2,'西游记');

insert into `user_book_relation`(`user_id`, `book_id`)
values ( 1, 2 ),
       (2, 1),
       (2,1),
       (2,2);