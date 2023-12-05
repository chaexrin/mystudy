package com.eomcs.oop.ex02.step17.vo;


public class Score {

  // public을 메서드 앞에 붙여서 공개해야 다른 패키지에서 접근 가능.
  public String name;
  public int kor;
  public int eng;
  public int math;
  public int sum;
  public float aver;

  public void compute() {
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

