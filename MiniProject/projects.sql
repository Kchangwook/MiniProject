--system[Admin계정에서 evcar계정 생성&권한부여
create user evcar identified by 1234;
grant connect,resource,dba to evcar;

--테이블 확인
select * from tab;

--지우는 순서
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
car_max_distance	NUMBER          not null,
car_efficiency	    VARCHAR2(20)    not null,
car_img_src	        VARCHAR2(200)   not null,
constraint car_num_pk primary key(car_num)
);

create table Station(
station_num	        NUMBER,
station_addr	    VARCHAR2(255)   not null,
station_csnm	    VARCHAR2(100)   not null,
station_cpnm	    VARCHAR2(100)   not null,
station_lat	        NUMBER          not null,
station_longi	    NUMBER          not null,
constraint station_num_pk primary key(station_num)
);

create table Member(
member_mail	        VARCHAR2(50),
member_pwd	        VARCHAR2(50)    not null,
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
cpid                NUMBER(6), 
addr                VARCHAR2(255)   not null, 
csnm                VARCHAR2(50)    not null, 
cpnm                VARCHAR2(8)     not null, 
lat                 NUMBER(19,15)   not null,
longi               NUMBER(19,14)   not null, 
csid                NUMBER(5)       not null, 
cptp                NUMBER(2)       not null, 
cpstat              NUMBER(2)       not null,
statupdate          VARCHAR2(100)    not null,
CONSTRAINT station_pk PRIMARY KEY(cpid)
);
ALTER SESSION SET NLS_DATE_FORMAT='YYYY-MM-DD HH24:MI:SS';
select to_date(statupdate,'YYYY-MM-DD HH24:MI:SS') from station;
select * from station;
commit;