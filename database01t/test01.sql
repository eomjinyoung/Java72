/* 
테이블 생성 

create table 테이블명 (
  컬럼명 타입 [not null/null] [default 값] 기타 옵션들,
  컬럼명 타입 [not null/null] [default 값] 기타 옵션들,
  ...
)

- DBMS는 대소문자를 구분하지 않는다.
- 낙타 표기법 대신 --> 이름약어_이름약어_이름약어 
  예) firstName --> fst_nm
- 테이블 이름이나 컬럼 이름을 약어로 표기한다. 
   
 */
create table board (
  bno   int,
  title   varchar(255),
  content mediumtext,
  views int,
  cre_dt  datetime,
  pwd   varchar(20)
);

/* 테이블 삭제 */
drop table board;

/* 
데이터 입력 
insert into 테이블명(컬럼명, ...) values(값, ...)
*/
insert into board(bno,title,content,cre_dt)
values(1, '1111', '11111111', now());
insert into board(bno,title,content,cre_dt)
values(2, '2222', '11111111', now());
insert into board(bno,title,content,cre_dt)
values(3, '3333', '11111111', now());
insert into board(bno,title,content,cre_dt)
values(4, '4444', '11111111', now());
insert into board(bno,title,content,cre_dt)
values(5, '5555', '11111111', now());

/* 
데이터 질의
select 컬럼명, 컬럼명, ...  from 테이블명
select * from 테이블명
 */
select * from board;

/*
데이터 변경
update 테이블명 set 컬럼명=값, 컬럼명=값, ... where 조건
 */
update board set pwd='1111';

/* 
기존 데이터 변경
 */
update board set title='2222222' where bno=2;

/*
데이터 삭제하기
delete from 테이블명 where 조건
 */
delete from board where bno=5;



/*
mysql 사용 명령
프롬프트> mysql -u 사용자아이디 -p
암호: 사용자암호

* 사용자가 사용할 수 있는 데이터베이스 목록을 출력한다.
mysql> show databases; 

* 사용할 데이터베이스 지정
mysql> connect java72db;

* 데이터베이스의 테이블 목록을 출력하기
mysql> show tables;

 */




























