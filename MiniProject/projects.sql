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
car_max_distance	NUMBER      ,
car_efficiency	    VARCHAR2(20)    ,
car_img_src	        VARCHAR2(200)   not null,
constraint car_num_pk primary key(car_num)
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

CREATE TABLE "EVCAR"."STATION" 
   (	"CPID" NUMBER(6,0), 
"ADDR" VARCHAR2(255 BYTE) NOT NULL ENABLE, 
"CSNM" VARCHAR2(50 BYTE) NOT NULL ENABLE, 
"CPNM" VARCHAR2(8 BYTE) NOT NULL ENABLE, 
"LAT" NUMBER(19,15) NOT NULL ENABLE, 
"LONGI" NUMBER(19,14) NOT NULL ENABLE, 
"CSID" NUMBER(5,0) NOT NULL ENABLE, 
"CPTP" NUMBER(2,0) NOT NULL ENABLE, 
"CPSTAT" NUMBER(2,0) NOT NULL ENABLE, 
 CONSTRAINT "STATION_PK" PRIMARY KEY ("CPID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;

commit;