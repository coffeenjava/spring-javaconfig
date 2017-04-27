create table user (
  user_id varchar(50) not null primary key,
  user_nm varchar(50) null,
  phone varchar(50) null,
  comment varchar(1000) null
);

insert into user (user_id, user_nm, phone, comment) values ('lcrapper', '이수일킹왕짱', '0101234568', '킹왕짱');
insert into user (user_id, user_nm, phone, comment) values ('kjs', '김지수', '??', '안킹왕짱');