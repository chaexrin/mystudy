package com.eomcs.oop.ex02.step06;

public class Calculator {

  int result = 0;// 인스턴스 변수

  // 인스턴스 변수를 다룰 때는 인스턴스 메서드를 사용하는 것이 편하다!
  // 왜?
  // - 인스턴스 주소를 파라미터로 받을 필요가 없기 때문이다.
  // - 메서드를 호출할 때 앞쪽에 인스턴스 주소를 지정한다.

  // 인스턴스 메서드는 static 붙이지 않는다
  // - 메서드를 호출할 때 앞에서 전달한 인스턴스 주소를 받을 수 있도록
  // this라는 이름의 내장 변수를 갖고 있다.

  void plus(int value) {
    this.result += value;
  }

  void minus(int value) {
    this.result -= value;
  }

  void multiple(int value) {
    this.result *= value;
  }

  void divide(int value) {
    this.result /= value;
  }

  // 인스턴스를 사용하지 않는 메서드라면 그냥 클래스 메서드로 두어라.
  // abs 메서드는 result 변수를 사용하지 않기 때문에 instance 주소를 받을 필요가 없다.
  static int abs(int a) {
    return a >= 0 ? a : a * -1;
    // static 메서드는 this라는 내장 변수가 없다.
  }

}


