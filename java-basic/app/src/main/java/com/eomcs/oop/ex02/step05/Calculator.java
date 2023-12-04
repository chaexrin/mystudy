package com.eomcs.oop.ex02.step05;

public class Calculator {

  // 인스턴스 변수(= non-static 변수)
  // - 작업 결과를 개별적으로 관리하고 싶을 때 인스턴스 변수로 선언한다.
  // - 인스턴스 변수는 클래스가 로딩 될 때 만들어지지 않는다.
  // - new 명령을 사용해서 만들어야 한다.
  // - 변수 선언 앞에 static이 붙지 않는다.
  int result = 0;// 인스턴스 변수

  // 메서드의 작업 결과는 인스턴스 변수에 보관한다.
  // 그러기 위해 메서드가 호출될 대 인스턴스 주소를 받아야한다.
  static void plus(Calculator instance, int value) {
    instance.result += value; // result = result + value
  }

  static void minus(Calculator instance, int value) {
    instance.result -= value; // result = result - value
  }

  static void multiple(Calculator instance, int value) {
    instance.result *= value; // result = result * value
  }

  static void divide(Calculator instance, int value) {
    instance.result /= value; // result = result / value
  }

  // 인스턴스를 사용하지 않는 메서드라면 그냥 클래스 메서드로 두어라.
  // abs 메서드는 result 변수를 사용하지 않기 때문에 instance 주소를 받을 필요가 없다.
  static int abs(int a) {
    return a >= 0 ? a : a * -1;
  }
}


