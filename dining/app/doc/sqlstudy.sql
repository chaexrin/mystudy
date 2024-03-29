-- my SQL 접속하기 
-- mysql -u 사용자명 -p 데이터베이스이름
-- mysql -u root (계정과 비번을 만들지 않았을때)
-- mysql -u root -p(루트 비번이 있을때)

-- IT 회사 RDB 만들어보기! 

-- 데이터 베이스 목록 조회
SHOW DATABASES;

-- 데이터 베이스 삭제
DROP DATABASE if exists company;

-- 현재 어떤 db 사용중인지 조회
SELECT database();

-- 데이터 베이스 생성 
CREATE DATABASE company;

-- DEPARTMENT 테이블 생성
create table DEPARTMENT (
     id INT PRIMARY KEY,
     name VARCHAR(20) NOT NULL UNIQUE,
     leader_id INT
     );

-- EMPLOYEE 테이블 생성
 create table EMPLOYEE (
    id INT PRIMARY KEY,
    name VARCHAR(30) NOT NULL,
    birth_date DATE,
    sex CHAR(1) CHECK (sex in('M','F')),
    position VARCHAR(10),
    salary INT DEFAULT 50000000,
    dept_id INT,
    FOREIGN KEY (dept_id) references DEPARTMENT(id)
    on delete SET NULL on update CASCADE,
    CHECK (salary >= 50000000)
    );

-- PROJECT 테이블 생성
create table PROJECT (
    id INT PRIMARY KEY,
    name VARCHAR(20) NOT NULL UNIQUE,
    leader_id INT,
    start_date DATE,
    end_date DATE,
    FOREIGN KEY (leader_id) references EMPLOYEE(id)
    on delete SET NULL on update CASCADE,
    CHECK (start_date < end_date)
);

-- WORKS_ON 테이블 생성
create table WORKS_ON (
    empl_id INT,
    proj_id INT,
    PRIMARY KEY (empl_id, proj_id),
    FOREIGN KEY (empl_id) references EMPLOYEE(id)
    on delete CASCADE on update CASCADE,
    FOREIGN KEY (proj_id) references PROJECT(id)
    on delete CASCADE on update CASCADE
);

-- 테이블이 만들어진 후에 테이블 스키마 변경
ALTER TABLE DEPARTMENT ADD FOREIGN KEY (leader_id)
references EMPLOYEE(id)
on update CASCADE
on delete SET NULL;

-- DB 추가 
-- insert statement
-- insert into table_name values (comma-separated all values);
-- insert into table_name (attribute list) values (attribute list 순서와 동일하게 comma-separated values);
-- insert into table_name values ( , , , ), ( , , , ), ( , , , ); 여러개 데이터 입력가능
insert into EMPLOYEE
values (1, 'MESSI', '1987-02-01', 'M', 'DEV_BACK', 100000000, null);

insert into EMPLOYEE
values (2, 'JANE', '1996-05-01', 'F', 'DSGN', 90000000, null);

insert into EMPLOYEE (name, birth_date, sex, position, id)
values ('JENNY', '2000-10-12', 'F', 'DEV_BACK', 3);

insert into EMPLOYEE values
(4, 'BROWN', '1997-03-25', 'M', 'CEO', 120000000, null),
(5, 'DINGYO', '1996-05-14', 'M', 'CTO', 120000000, null),
(6, 'JULIA', '1999-09-23', 'M', 'CFO', 120000000, null),
(7, 'MINA', '1998-08-08', 'F', 'DSGN', 80000000, null),
(8, 'JOHN', '1992-06-05', 'F', 'DEV_FRONT', 65000000, null),
(9, 'HENRY', '1991-09-12', 'M', 'HR', 82000000, null),
(10, 'NICOLE', '1992-08-04', 'F', 'DEV_FRONT', 65000000, null),
(11, 'SUZANNE', '1998-09-10', 'M', 'PO', 90000000, null),
(12, 'CURRY', '1994-07-19', 'M', 'PLN', 75000000, null),
(13, 'JISUNG', '1996-07-23', 'F', 'PO', 85000000, null),
(14, 'SAM', '1993-05-13', 'M', 'DEV_INFRA', 90000000, null);

insert into DEPARTMENT values
(1001, 'headquarter', 4),
(1002, 'HR', 6),
(1003, 'development', 1),
(1004, 'design', 3),
(1005, 'product', 13);

insert into PROJECT values
(2001, '쿠폰 구매/선물 서비스 개발', 13, '2022-03-10', '2022-07-09'),
(2002, '확장성 있게 백엔드 리팩토링', 13, '2022-01-23', '2022-03-23'),
(2003, '홈페이지 UI 개선', 11, '2022-05-09', '2022-06-11');

insert into WORKS_ON values
(5,2001),
(13,2001),
(1,2001),
(8,2001),
(9,2001),
(2,2001),
(7,2003),
(14,2003),
(12,2003),
(3,2003),
(4,2003),
(6,2001),
(11,2003),
(10,2001);

-- 수정
update employee set dept_id = 1003 where id = 1;

-- 개발툄 연봉을 두배로 인상하고 싶을 때
update employee 
set salary = salary * 2
where dept_id = 1003;

update employee, WORKS_ON
set salary = salary * 2
where employee.id = WORKS_ON.empl_id and proj_id = 2003;

-- 삭제

delete from employee where id = 8;

delete from WORKS_ON where empl_id = 2;

delete from WORKS_ON where empl_id = 5 and proj_id != 2001;

-- 조회
SELECT name, position from EMPLOYEE where id = 9;

select employee.id, employee.name, position 
from PROJECT, employee
where PROJECT.id = 2003 and PROJECT.leader_id = employee.id;

-- DISTINCT 사용 (SELECT문에서 중복결과 제거)
select DISTINCT P.id, P.name
from employee as E, WORKS_ON as W, PROJECT as P
where E.position = 'DSGN' and
E.id = W.empl_id and W.proj_id = P.id;

-- Like 사용
select name
from employee
where name Like 'N%' or name Like '%N';

select name from employee where name Like 'J____';

-- escape 문자와 함께 사용하기
-- %로 시작하거나 _로 끝나는 프로젝트 이름을 찾고 싶다면?
select name from PROJECT where name LIKE '\%%' or name LIKE '%\_';

-- * (asterisk) 사용하기
-- 선택된 tuple의 모든 attribute 를 보여주고 싶을 때
select * from employee where id = 9;

select * 
from PROJECT, employee
where project.id = 2002 and project.leader_id = employee.id;

-- select without where
-- 해당 테이블의 모든 tuples 조회
select name, birth_date
from employee;

-- 1. SELECT로 조회할 때 조건들을 포함해서 조회를 한다면
-- 해당 조건들과 관련된 attributes에 index가 걸려있어야 한다.
-- 그렇지 않다면 데이터가 많아질수록 조회속도가 느려진다.

-- <서브쿼리>
-- ID가 14인 임직원보다 생일이 빠른 임직원의 ID, 이름, 생일을 알고싶을 때

select birth_date from employee where id = 14;

select id, name, birth_date from employee
   where birth_date < '1993-05-13';

-- 위의 쿼리를 합쳤을 때 
-- >>>
select id, name, birth_date from employee
where birth_date < (select birth_date from employee where id = 14);

-- subquery : (nested query or inner query); SELECT, INSERT, UPDATE, DELETE 에 포함된 query
-- outer query(main query): subquery를 포함하는 query
-- subquery는 ()안에 기술된다.

-- ID 가 1인 임직원과 같은 부서 같은 성별인 임직원들의 ID와 이름과 직군을 알고싶다
SELECT id, name, position
from employee
where (dept_id, sex) = (
    SELECT dept_id, sex
    from employee
    WHERE id = 1
);

-- ID가 5인 임직원과 같은 프로젝트에 참여한 임직원들의 Id를 알고싶다.
SELECT proj_id from WORKS_ON where empl_id = 5;

SELECT DISTINCT empl_id from WORKS_ON
where empl_id != 5 and (proj_id = 2001 or proj_id = 2002);

-- (proj_id = 2001 or proj_id = 2002) = proj_id IN(2001, 2002)

-- 위의 두 쿼리를 합쳤을 때
Select DISTINCT empl_id from WORKS_ON
where empl_id != 5 and proj_id in ( select proj_id from WORKS_ON where empl_id = 5);

-- unqualified attribute가 참조하는 table은 해당 attribute가 사용된 query를 포함하여
-- 그 query의 바깥쪽으로 존재하는 모든 queries 중에 해당 attribute 이름을 가지는 가장 가까이에 있는 table을 참조한다.

---- ID가 5인 임직원과 같은 프로젝트에 참여한 임직원들의 Id와 이름을 알고싶다.
SELECT id, name 
FROM employee , 
(
    select DISTINCT empl_id from WORKS_ON
where empl_id != 5 and proj_id in ( select proj_id from WORKS_ON where empl_id = 5)
) AS DISTINCT_E
where id = DISTINCT_E.empl_id;

-- ID가 7 혹은 12인 임직원이 참여한 프로젝트의 ID와 이름을 알고싶다
SELECT P.id, P.name
FROM project p
WHERE EXISTS (
    SELECT *
    FROM WORKS_ON W 
    WHERE W.proj_id = P.id AND W.empl_id IN (7,12)
);

-- correlated query: subquery가 바깥쪽 query의 attribute를 참조할 때, correlated subquery라 부름

-- EXISTS: subquery의 결과가 최소 하나의 row라도 있다면 TRUE를 반환

-- NOT EXISTS: subquery의 결과가 단 하나의 row도 없다면 TRUE를 반환