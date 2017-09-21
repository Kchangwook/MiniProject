
drop sequence free_num;
drop sequence faq_num;
drop table free;
drop table car;
drop table station;
drop table member;
drop table faq;

create sequence free_num start with 1 increment by 1;
create sequence faq_num start with 1 increment by 1;

create table Car(
car_num	number,
car_price	number,
car_size	varchar(20),
car_max_distance	number,
car_efficiency	varchar(20),
car_img_src	varchar(200),
constraint car_num_pk primary key(car_num)
);

create table Station(
station_num	    number,
station_addr	VARCHAR(255) not null,
station_csnm	VARCHAR(100) not null,
station_cpnm	VARCHAR(100) not null,
station_lat	    number      not null,
station_longi	number      not null,
constraint station_num_pk primary key(station_num)
);

create table Member(
member_id	VARCHAR(50),
member_pwd	VARCHAR(50),
member_name	VARCHAR(50),
member_mail	VARCHAR(50),
member_addr	VARCHAR(255),
member_phone	VARCHAR(15),
member_level	number,
constraint member_id_pk primary key(member_id)
);

create table Free(
Free_num	number,
Free_title	VARCHAR(50),
Free_content	VARCHAR(1024),
member_id	VARCHAR(50),
Free_notice	number,
constraint free_num_pk primary key(free_num),
constraint free_member_id_fk foreign key(member_id) references member(member_id)
);

create table FAQ(
faq_num	number,
faq_title	VARCHAR(50),
faq_content	VARCHAR(1024),
constraint faq_num_pk primary key(faq_num)
);


select * from station;

commit;