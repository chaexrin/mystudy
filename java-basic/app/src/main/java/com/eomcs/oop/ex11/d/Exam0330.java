// 로컬 클래스에서 메서드에 선언된 로컬 변수 접근하기
package com.eomcs.oop.ex11.d;

class D3 {

  void m1() {
    final int v1 = 1;
    int v2 = 2;
    int v3 = 3;

    class X {
      void f() {
        // 로컬 클래스에서는 바깥 메서드의 로컬 변수를 사용할 수 있다.
        // 1) final 로 선언된 경우
        System.out.printf("v1 = %d\n", v1);

        // 2) final 로 선언된 것은 아니지만 값을 한 번만 할당한 경우.
        System.out.printf("v2 = %d\n", v2);

        // => 값을 여러 번 할당한 경우에는 접근할 수 없다.
        System.out.printf("v3 = %d\n", v3); // 컴파일 오류!

        // 결론!
        // - 상수 값이거나 상수에 준하는 경우(값을 한 번만 할당한 경우)
        // 로컬 클래스에서 메서드의 로컬 변수를 사용할 수 있다.
        // - 즉 로컬 클래스에서 바깥 메서드의 로컬 변수를 사용하는 상황?
        // 값을 조회하는 용도할 때.
        // - 왜?
        // 로컬 객체가 사용하는 로컬 변수는
        // 메서드 호출이 끝났을 때 제거되기 때문이다.
      }
    }

    X obj = new X();

    // 로컬 클래스 x의 객체를 만들 때는 v3 값이 3이었다.
    // 그런데 X.f()를 호출하기 전에 v3 변수의 값을 바꿨다.
    // 물론 X 인스턴스 obj에는 이전의 v3값인 3이 저장되어 있겠지만,
    // 어떤 개발자는 X.f()를 호출할 때 30으로 변경된 값이 사용할 것이라고 판단할 수 있고,
    // 또 어떤 개발자는 v3 값이 변경되기 전에 X 객체를 만들었기 때문에
    // 계속 v3 값은 3일 것이라고 생각할 수도 있을 것이다.
    // 이런 혼란스러운 상황을 피하기 위해 로컬 클래스에서 enclosing 메서드의 변수를 사용할 때는
    // 해당 변수를 변경하지 않는 경우에만 허락하도록 규칙이 정해져 있다.
    v3 = 30;
    obj.f();
  }
}


public class Exam0330 {

  public static void main(String[] args) {
    D3 obj = new D3();
    obj.m1();
  }

}
