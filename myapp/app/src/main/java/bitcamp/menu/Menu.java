package bitcamp.menu;

import bitcamp.util.Prompt;

// Menu를 처리하는 객체의 사용법을 정의.
public interface Menu {

  // 객체를 실행할 때 호출할 메서드를 선언.
  // 구현을 해서는 안됨. -> 추상적.. => 추상 메서드
  // 인터페이스에서 메서드 생성할 때 public abstract 생략 가능
  public abstract void execute(Prompt prompt);

  public abstract String getTitle();


}
