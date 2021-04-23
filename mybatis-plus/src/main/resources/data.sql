insert into user(id, username, email, password, locked, create_at, update_at)
values (1, 'username', '123456@qq.com',
        '$shiro1$SHA-256$500000$Rn/qgay6R3wBGQOnPpJFIg==$h8ReDeaI/qNHIMw4Hdeg5fCT205e9lg0bDCTxWiJbWQ=', 1,
        '2020-12-27 23:05:47', '2020-12-27 23:05:51')
    insert
into student(id, name)
values (1, 'xiaoming')
insert into book(id, name)
values (1, '西游记')
insert into book(id, name)
values (2, '红楼梦')
insert into book(id, name)
values (3, '水浒传')

insert into student_book(student_id, book_id)
values (1, 1)
insert into student_book(student_id, book_id)
values (1, 3)