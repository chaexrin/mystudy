-- DDL(Data Definition Language)

-- table 삭제
drop table reservations;

create table reservations(
reservation_no int primary key auto_increment COMMENT '예약번호',
name varchar(50) not null COMMENT '예약번호',
reservation_date date not null COMMENT '예약일자',
reservation_time int not null COMMENT '예약시간',
ppl int not null COMMENT '인원',
tel varchar(20) not null COMMENT '전화번호',
created_date datetime null default now() COMMENT '작성일시'
);

-- insert into 테이블명(필수 컬럼) values (싱글 quotation);
insert into reservations(name,reservation_date, reservation_time, ppl, tel)
  values('홍길동', '2024-02-01', '8', '3', '01011111111');
insert into reservations(name,reservation_date, reservation_time, ppl, tel)
  values('장영실', '2024-03-01', '9', '9', '01011111112');
insert into reservations(name,reservation_date, reservation_time, ppl, tel)
  values('이세종', '2024-04-01', '10', '2', '01011111113');
insert into reservations(name,reservation_date, reservation_time, ppl, tel)
  values('조승우', '2024-05-01', '11', '8', '01011111114');
insert into reservations(name,reservation_date, reservation_time, ppl, tel)
  values('김지민', '2024-06-01', '12', '5', '01011111115');
  insert into reservations(name,reservation_date, reservation_time, ppl, tel)
    values('김미도', '2024-06-01', '14', '3', '010111324115');

-- 보드에 있는 모든 컬럼 테이블 형태로 복사
select *
from reservations;

-- 한개의 데이터 조회할 때
select *
from reservations
where reservation_no = 3;

-- 게시글 변경
update reservations set
  name='Alex'
  reservation_date='2024-03-02',
  reservation_time='13',
  ppl='35',
  tel='01022222222'
  where reservation_no = 3;

  -- 특정 게시글 삭제
  delete from reservations where reservation_no=3;


-- 기존 테이블에 컬럼 추가
alter table reservations
  add column category int not null;

 -- 기존 입력된 데이터는 카테고리 1로 설정
update reservations set category=1;