insert into course(id,name,created_date,last_update_date) values (100, 'Jpa 01',sysdate(),sysdate());
insert into course(id,name,created_date,last_update_date) values (101, 'Jpa 02',sysdate(),sysdate());

insert into passport(id,number) values (10000,'A111111');
insert into passport(id,number) values (10001,'A222222');
insert into passport(id,number) values (10002,'A333333');

insert into student(id,name,passport_id) values (1000,'Zakaria',10000);
insert into student(id,name,passport_id) values (1001,'Sofia',10001);
insert into student(id,name,passport_id) values (1002,'Kassym',10002);

insert into review(id,rating,description) values (10,'5','Tres Bon cours');
insert into review(id,rating,description) values (11,'4','Bon cours');
insert into review(id,rating,description) values (12,'5','Tres Bon cours');