package com.eomcs.oop.ex02.step15;

// 사용자 정의 데이터 타입 만들기
// - 학생의 성적 데이터를 담을 전용 메모리(변수)를 설계한다.
// - 학생 데이터를 묶음으로 다룰 수 있도록 변수 그룹을 정의한다.

public class Score {

  String name;
  int kor;
  int eng;
  int math;
  int sum;
  float aver;

  // Score 데이터 값을 다루는 메서드는 Score 데이터를 선언한 클래스에
  // 가까이 두는 것이 유지보수에 좋다.
  // GRASP 패턴의 'Information Expert' 설계 기법을 적용한 예이다.
  static void compute(Score s) {
    s.sum = s.kor + s.eng + s.math;
    s.aver = s.sum / 3f;
  }

  // compute()메서드는 Score 데이터를 다루는 메서드
  // - 즉 Score 타입의 데이터를 다룰 수 있는 '연산자'라 할 수 있다.
  // - 즉 사용자 정의 데이터 타입 입장에서는 그 데이터를 다루는 메서드가 연산자 인 것
  // - 사용자 정의 데이터 타입에 메서드를 정의하는 것은
  // 그 데이터를 다룰 연산자를 정의하는 것과 같다.

}

