/*
데이터 조회
*/
-- wild card 사용 : create table의 정의 순선대로 전체 컬럼 값을 선택한다.
select * from board10;

-- 특정 컬럼만 선택할 수 있다.
select title, bno from board10;

-- 조회 조건 지정하기
select bno, title
from board10
where bno=2;

select bno, title
from board10
where bno > 5;

select bno, title
from board10
where bno >= 5;

-- 실행 순서: from -> where -> select
select bno, title   
from board10
where bno >= 5 and bno <= 8;

select bno, title   
from board10
where bno < 5 or bno > 8;

select bno, title   
from board10
where bno <> 5;

select bno, title   
from board10
where bno != 5;

select bno, title   
from board10
where not bno = 5;

select bno, title   
from board10
where bno in (1, 3, 5, 8);

select bno, title   
from board10
where bno not in (1, 3, 5, 8);

select bno, title   
from board10
where bno between 5 and 8;

-- 컬럼 선택하기
select bno, title, cre_dt
from board10;

-- 컬럼에 별명 붙이기: 컬럼명 [as] 별명
select bno as boardNo, title, cre_dt as createdDate
from board10;

select bno boardNo, title, cre_dt createdDate
from board10;

-- 컬럼 값을 합치기
select concat('(',bno,')',title,'(',cre_dt,')') as boardInfo
from board10;


















