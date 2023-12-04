package com.eomcs.oop.ex02.step07;

import com.eomcs.oop.ex02.step07.util.Calculator;

// # 관련된 기능(메서드)을 묶어 분류하기
// 1) 분류 전
// 2) 메서드를 클래스로 묶어 분류하기
// 3) 클래스 변수 도입
// 4) 클래스 변수의 한계 확인
// 5) 인스턴스 변수 도입
// 6) 인스턴스 메서드 활용
// 7) 클래스를 역할에 따라 패키지로 분류하기
// - Calculator 클래스를 향후 유지보수하기 쉽도록 별도의 패키지로 분류.
// - com.eomcs.oop.ex02.util 패키지로 만들어 분류
// - import 사용하여 타 패키지에 있는 클래스..가져오기

public class App {


  public static void main(String[] args) {

    // 클래스에 정의된 인스턴스 변수를 Heap 영역에 생성
    // 다른 패키지의 클래스를 사용하려면 반드시 패키지명을 이름과 함께 지정해야한다.
    // com.eomcs.oop.ex02.step07.util.Calculator c1 = new
    // com.eomcs.oop.ex02.step07.util.Calculator();
    // com.eomcs.oop.ex02.step07.util.Calculator c2 = new
    // com.eomcs.oop.ex02.step07.util.Calculator();

    // import명령 사용하여 클래스의 패키지 이름을 미리 알려준다면,
    // 클래스 지정할 때 패키지 이름을 나열할 필요가 없다.
    Calculator c1 = new Calculator();
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

