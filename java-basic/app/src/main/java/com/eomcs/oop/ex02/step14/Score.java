package com.eomcs.oop.ex02.step14;

// 사용자 정의 데이터 타입 만들기
// - 학생의 성적 데이터를 담을 전용 메모리(변수)를 설계한다.
// - 학생 데이터를 묶음으로 다룰 수 있도록 변수 그룹을 정의한다.

public class Score {

  // 여러 메서드에서 공유하려면 클래스 멤버로 만들어야 한다.
  // - 특히 스태틱 멤버끼리 공유하려면 같은 스태틱 멤버로 만들어야 한다.
  String name;
  int kor;
  int eng;
  int math;
  int sum;
  float aver;


}

