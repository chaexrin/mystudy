-- DDL(Data Definition Language)

-- table 삭제
drop table boards;

create table boards(
board_no int primary key auto_increment,
title varchar(255) not null,
content text not null,
writer varchar(30) not null,
created_date datetime null default now()
);

-- insert into 테이블명(필수 컬럼) values (싱글 quotation);
insert into boards(board_no,title,content,writer)
  values(1, '제목1', '내용1', '홍길동');
insert into boards(board_no,title,content,writer)
  values(2, '제목2', '내용2', '임꺽정');
insert into boards(board_no,title,content,writer)
  values(3, '제목3', '내용3', '유관순');
insert into boards(board_no,title,content,writer)
  values(4, '제목4', '내용4', '안중근');
insert into boards(board_no,title,content,writer)
  values(5, '제목5', '내용5', '윤봉길');

-- 보드에 있는 모든 컬럼 테이블 형태로 복사
select *
from boards;

-- 한개의 데이터 조회할 때
select *
from boards
where board_no = 3;

-- 게시글 변경
update boards set
  title='okok',
  content='nono',
  writer='hoho'
  where board_no = 3;

  -- 특정 게시글 삭제
  delete from boards where board_no=3;

-- 과제 게시판 삭제
drop table assignment;

  -- 과제
  create table assignments(
  assignment_no int primary key auto_increment,
  title varchar(255) not null,
  content text not null,
  deadline date not null
  );

  insert into assignments(assignment_no,title,content,deadline)
    values(1, '제목1', '내용1', '2024-02-08');
  insert into assignments(assignment_no,title,content,deadline)
    values(2, '제목2', '내용2', '2024-02-29');

    select *
    from assignments;

      -- 회원
      create table members(
      member_no int primary key auto_increment,
      email varchar(255) not null,
     name varchar(255) not null,
       password varchar(100) not null,
       created_date datetime null default now()
      );

      insert into members(email,name,password,created_date)
      values('user1@test.com', 'user1', sha2('1111',256),'2024-02-04');


-- 기존 테이블에 컬럼 추가
alter table boards
  add column category int not null;

 -- 기존 입력된 데이터는 카테고리 1로 설정
update boards set category=1;