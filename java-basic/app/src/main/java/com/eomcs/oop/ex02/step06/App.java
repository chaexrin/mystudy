package com.eomcs.oop.ex02.step06;

// # 관련된 기능(메서드)을 묶어 분류하기
// 1) 분류 전
// 2) 메서드를 클래스로 묶어 분류하기
// 3) 클래스 변수 도입
// 4) 클래스 변수의 한계 확인
// 5) 인스턴스 변수 도입
// 6) 인스턴스 메서드 활용

public class App {


  public static void main(String[] args) {

    Calculator c1 = new Calculator(); // 클래스에 정의된 인스턴스 변수를 Heap 영역에 생성
    Calculator c2 = new Calculator();

    // 인스턴스의 주소를 메서드 앞으로 전달한다.
    // Calculator.plus(c1, 2);
    c1.plus(2);
    c2.plus(3);

    c1.plus(3);
    c2.multiple(2);

    c1.minus(1);
    c2.plus(7);

    c1.multiple(7);
    c2.divide(4);

    c1.divide(3);
    c2.minus(5);

    // Calculator.~~~ 순서 섞어도 상관없음..!

    System.out.printf("result = %d\n", c1.result);
    System.out.printf("result = %d\n", c2.result);
  }
}

