delete from post where id=11001 or id=11002;

delete from user_details where id in (10001, 10002, 10003);

insert into user_details(id, birth_date, name)
values(10001, current_date(), 'Archie');

insert into user_details(id, birth_date, name)
values(10002, current_date(), 'Benny');

insert into user_details(id, birth_date, name)
values(10003, current_date(), 'Cathy');

insert into post(id, description, user_id) values(11001, 'My First Post', 10001);

insert into post(id, description, user_id) values(11002, 'My Second Post', 10001);