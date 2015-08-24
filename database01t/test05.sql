create table member (
  mno       int not null,
  mname     varchar(20) not null,
  email     varchar(100) not null,
  pwd       varchar(20) not null,
  tel       varchar(20),
  photo     varchar(255),
  cre_dt    datetime not null
);  

alter table member
  add constraint member_pk primary key (mno);
 
alter table member
  modify column mno int not null auto_increment;
  
alter table member
  add constraint member_uk unique key (email); 
  

  
  
  
  
  
  
  
  
  