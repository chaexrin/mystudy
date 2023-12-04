package com.eomcs.oop.ex02.step07.util;

// 다른 패키지에서 이 클래스와 멤버(필드 및 메서드)에 접근할 수 있도록 public으로 공개해야한다.
public class Calculator {

  public int result = 0;// 인스턴스 변수

  public void plus(int value) {
    this.result += value;
  }

  public void minus(int value) {
    this.result -= value;
  }

  public void multiple(int value) {
    this.result *= value;
  }

  public void divide(int value) {
    this.result /= value;
  }

  // 인스턴스를 사용하지 않는 메서드라면 그냥 클래스 메서드로 두어라.
  // abs 메서드는 result 변수를 사용하지 않기 때문에 instance 주소를 받을 필요가 없다.
  public static int abs(int a) {
    return a >= 0 ? a : a * -1;
    // static 메서드는 this라는 내장 변수가 없다.
  }

}


