
select * from member;

--?Öå?ù¥Î∏? ?ôï?ù∏
select * from tab;

--Ïß??ö∞?äî ?àú?Ñú
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
car_num	            NUMBER,
car_name            VARCHAR2(50)    not null,
car_price	        NUMBER          not null,
car_size	        VARCHAR2(20)    not null,
car_max_distance	NUMBER          null,
car_efficiency	    VARCHAR2(20)    null,
car_img_src	        VARCHAR2(200)   not null,
constraint car_num_pk primary key(car_num)
);

create table Member(
member_mail	        VARCHAR2(150),
member_pwd	        VARCHAR2(150)    not null,
member_name	        VARCHAR2(50)    not null,
member_addr	        VARCHAR2(255)   not null,
member_phone	    VARCHAR2(15)    not null,
member_level	    NUMBER          not null,
member_salt         VARCHAR2(100)   not null,
constraint member_mail_pk primary key(member_mail)
);

create table Free(
Free_num	        NUMBER,
Free_title	        VARCHAR2(50)    not null,
Free_content	    VARCHAR2(300)   not null,
Free_notice	        NUMBER          not null,
member_mail	        VARCHAR2(50)    not null,
constraint free_num_pk primary key(free_num),
constraint free_member_mail_fk foreign key(member_mail) references member(member_mail)
);

create table FAQ(
faq_num	            NUMBER,
faq_title	        VARCHAR2(50)    not null,
faq_content	        VARCHAR2(3000)  not null,
constraint faq_num_pk primary key(faq_num)
);

CREATE TABLE STATION(
station_cpid                NUMBER(6), 
station_addr                VARCHAR2(255)   not null, 
station_csnm                VARCHAR2(50)    not null, 
station_cpnm                VARCHAR2(8)     not null, 
station_lat                 NUMBER(19,15)   not null,
station_longi               NUMBER(19,14)   not null, 
station_csid                NUMBER(5)       not null, 
station_cptp                NUMBER(2)       not null, 
station_cpstat              NUMBER(2)       not null,
station_statupdate          VARCHAR2(100)    not null,
CONSTRAINT station_pk PRIMARY KEY(station_cpid)
);
select * from station;
commit;