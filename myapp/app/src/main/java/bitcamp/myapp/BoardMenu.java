package bitcamp.myapp;

public class BoardMenu {


  static void printMenu() {
    System.out.println("[게시글]");
    System.out.println("1. 등록");
    System.out.println("2. 조회");
    System.out.println("3. 변경");
    System.out.println("4. 삭제");
    System.out.println("0. 이전");
  }


  static void execute() {
    printMenu();

    while (true) {
      String input = Prompt.input("메인/게시글> ");
      switch (input) {
        case "1":
          Board.add();
          break;
        case "2":
          Board.view();
          break;
        case "3":
          Board.modify();
          break;
        case "4":
          Board.delete();
          break;
        case "0":
          return;
        case "board":
          BoardMenu.printMenu();
          break;
        default:
          System.out.println("메뉴 번호가 옳지 않습니다!");
      }
    }
  }

}
