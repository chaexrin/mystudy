package com.eomcs.oop.ex02.step16;

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

  // static method를 instance method로 바꾸는 이유:
  // - 클래스 메서드로 연산자를 정의하면,
  // - 계산을 수행할 때마다 인스턴스의 주소를 파라미터로 받아야 한다.
  // - 매우 번거롭다.
  //
  // public static void calculate(Score score) {
  // score.sum = score.kor + score.eng + score.math;
  // score.average = score.sum / 3f;
  // }
  // - 그래서 자바는 "인스턴스 메서드"라는 것을 제공한다.
  //
  // compute: 연산자 (Score s): 피연산자

  void compute() {
    // 인스턴스 메서드를 호출할 때 넘겨준 인스턴스 주소는
    // this 라는 내장 변수(built-in)에 자동으로 보관된다.
    this.sum = this.kor + this.eng + this.math;
    this.aver = this.sum / 3f;
  }

  // 인스턴스 메서드 = non-static 메서드
  // - 메서드를 호출할 때 인스턴스의 주소를 파라미터로 넘기지 않는다.
  // - 메서드를 호출할 때(연산자를 사용할 때), 메서드 앞에 인스턴스 주소를 적는다.
  // - 이렇게 전달된 인스턴스 주소는 메서드에 내장된 this라는 변수에 자동 복사된다.
  // - 그래서 파라미터 대신 this를 사용하면 된다.
  // - 인스턴스 메서드는 static을 붙이지 않는다.
}

