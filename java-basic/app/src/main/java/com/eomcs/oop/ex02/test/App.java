package com.eomcs.oop.ex02.test;

// # 관련된 기능(메서드)을 묶어 분류하기
// 1) 분류 전
// 2) 메서드를 클래스로 묶어 분류하기
// 3) 클래스 변수 도입
// 4) 클래스 변수의 한계 확인
// 5) 인스턴스 변수 도입
// 6) 인스턴스 메서드 활용
// 7) 클래스를 역할에 따라 패키지로 분류하기

public class App {

  public static void main(String[] args) {

    Calculator c1 = new Calculator();
    Calculator c2 = new Calculator();

    Calculator.plus(c1, 2);
    c1.plus(3);
    c1.minus(1);
    Calculator.multiple(c1, 7);
    Calculator.divide(c1, 3);

    // result 변수가 어떤 인스턴스에 있는 변수인지 지정해야한다.
    System.out.printf("result = %d\n", c1.result);


    // 식2 계산:
    // 각각의 계산식 결과는 서로 다른 result 변수에 보관되기 때문에
    // 새로 초기화 시킬 필요가 없다.
    // Calculator.result = 0;

    Calculator.plus(c2, 3);
    Calculator.multiple(c2, 2);
    Calculator.plus(c2, 7);
    Calculator.divide(c2, 4);
    Calculator.minus(c2, 5);

    // Calculator.~~~ 순서 섞어도 상관없음..!

    System.out.printf("result = %d\n", c2.result);
  }


}

