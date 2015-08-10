create table test01 (
  bno   int not null,
  title   varchar(10) not null
);  
alter table test01
  add constraint test01_pk primary key (bno);
alter table test01
  modify column bno int not null auto_increment;

create table test02 (
  bno   int not null,
  title   varchar(10) not null
);  
alter table test02
  add constraint test02_pk primary key (bno);
alter table test02
  modify column bno int not null auto_increment
