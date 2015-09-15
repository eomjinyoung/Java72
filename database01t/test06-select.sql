/* 조인
 * => 여러 테이블에 분산되어 있는 데이터를 한군데로 모으기 
 */

/* 강의 정보 가져오기 */
select lno,title,cno from lectures;

/* 교실 정보 가져오기 */
select cno,loc,room from classrooms;

/* 강의 정보와 교실 정보를 함께 가져오기*/
select 
  lno,
  title,
  cno,
  (select loc from classrooms where cno=t1.cno) as loc,
  (select room from classrooms where cno=t1.cno) room
from lectures t1;

/* 1. cross 조인 
 * - 테이블의 각 레코드를 일:일로 연결하기 
 */
/* 조인을 통해서 강의실과 센터위치 정보를 가져오기 - 고전 문법*/
select 
  t1.lno,
  t1.title,
  t2.cno,
  t2.loc,
  t2.room
from lectures t1, classrooms t2;

/* SQL-1999 명세 표준 문법 */
select 
  t1.lno,
  t1.title,
  t2.cno,
  t2.loc,
  t2.room
from lectures t1 cross join classrooms t2;

/* 2. natural 조인
 * => 공통 컬럼을 기준으로 조인한다. 
 */
select 
  t1.lno,
  t1.title,
  t2.cno,
  t2.loc,
  t2.room
from lectures t1, classrooms t2
where t1.cno=t2.cno;

/* 같은 이름을 갖는 컬럼으로 데이터를 묶는다 */
select 
  t1.lno,
  t1.title,
  t2.cno,
  t2.loc,
  t2.room
from lectures t1 natural join classrooms t2;

/* 3. join ~ using 
 * => 조인할 때 사용할 컬럼을 지정하기 
 * => 조인할 두 테이블에 이름이 같은 컬럼이 여러 개 있을 때 유용한다.
 */
select 
  t1.lno,
  t1.title,
  t2.cno,
  t2.loc,
  t2.room
from lectures t1 join classrooms t2 using (cno);

/* 4. join ~ on
 * => 조인할 때 사용할 컬럼의 이름이 다를 경우
 */
select 
  t1.lno,
  t1.title,
  t2.cno,
  t2.loc,
  t2.room
from lectures t1 join classrooms t2 on t1.cno=t2.cno;

/* 5. left outer join ~ on 
 * => 왼쪽에 지명된 테이블을 기준으로 오른쪽 테이블 테이터를 연결한다.
 * => 왼쪽 테이블의 데이터는 오른쪽 테이블의 데이터와 묶이든
 *    묶이지 않든 상관없이 무조건 모두 선택된다.
 */
select 
  t1.lno,
  t1.title,
  t2.cno,
  t2.loc,
  t2.room
from lectures t1 left outer join classrooms t2 
     on t1.cno=t2.cno;

/* 6. right outer join ~ on
 * => 오른쪽 테이블을 기준으로 왼쪽 테이블의 데이터를 연결한다.
 */
select 
  t1.lno,
  t1.title,
  t2.cno,
  t2.loc,
  t2.room
from lectures t1 right outer join classrooms t2 
     on t1.cno=t2.cno;

/* 조인 응용: 강의 정보 출력하기 */
select 
  t1.lno
  ,t1.title
  ,t2.loc
  ,t2.room
  ,t3.name as manager
  ,t5.name teacher
  /*,t4.st_date
  ,t4.en_date*/
from lectures t1 
    left outer join classrooms t2 on t1.cno=t2.cno
    left outer join managers t3 on t1.mno=t3.mno
    left outer join lec_trai t4 on t1.lno=t4.lno
    left outer join trainers t5 on t4.tno=t5.tno;





