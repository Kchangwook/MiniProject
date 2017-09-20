
drop table station;
drop table member;
drop table faq;

create table Station(
station_num	    number,
station_addr	VARCHAR(255) not null,
station_csnm	VARCHAR(100) not null,
station_cpnm	VARCHAR(100) not null,
station_lat	    number      not null,
station_longi	number      not null,
constraint station_pk primary key(station_num)
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

create table FAQ(
faq_num	number,
faq_title	VARCHAR(50),
faq_content	VARCHAR(1024),
constraint faq_pk primary key(faq_num)
);


select * from station;

commit;