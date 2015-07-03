/*
기존 테이블에 컬럼 추가/삭제/변경 
*/
create table board9 (
  bno   int not null,
  title   varchar(255) not null ,
  content mediumtext,
  views int default 0,
  cre_dt  datetime not null,
  pwd   varchar(20)
);

alter table board9
  add constraint board9_pk primary key (bno,title);

alter table board9
  add column att_file varchar(255);

alter table board9
  drop column att_file;
  
alter table board9
  modify column att_file varchar(255) not null;
  
/* 
PK 컬럼의 값을 자동 증가시키기
 
 */  
create table board10 (
  bno   int not null,
  title   varchar(255) not null ,
  content mediumtext,
  views int default 0,
  cre_dt  datetime not null,
  pwd   varchar(20)
);  

-- 자동 증가 컬럼은 PK 이어야 한다.
alter table board10
  add constraint board10_pk primary key (bno);
 
-- 자동 증가 컬럼을 지정한다.
alter table board10
  modify column bno int not null auto_increment;
  
alter table board10
  add column att_file varchar(255); 
  
/*
테이블의 컬럼 이름 바꾸기
 */
alter table board10
  change column att_file att_file1 varchar(255);  

alter table board10
  add column att_file2 varchar(255); 

alter table board10
  add column att_file3 varchar(255);   
  
  
  
  
  
  
  
  
  
  
  