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
car_name		varchar2(50)	not null,
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
member_id	        VARCHAR2(50),
member_pwd	        VARCHAR2(50)    not null,
member_name	        VARCHAR2(50)    not null,
member_mail	        VARCHAR2(50)    not null,
member_addr	        VARCHAR2(255)   not null,
member_phone	    VARCHAR2(15)    not null,
member_level	    NUMBER          not null,
constraint member_id_pk primary key(member_id)
);

create table Free(
Free_num	        NUMBER,
Free_title	        VARCHAR2(50)    not null,
Free_content	    VARCHAR2(3000)  not null,
member_id	        VARCHAR2(50)    not null,
Free_notice	        NUMBER          not null,
constraint free_num_pk primary key(free_num),
constraint free_member_id_fk foreign key(member_id) references member(member_id)
);

create table FAQ(
faq_num	            NUMBER,
faq_title	        VARCHAR2(50)    not null,
faq_content	        VARCHAR2(3000)  not null,
constraint faq_num_pk primary key(faq_num)
);

commit;