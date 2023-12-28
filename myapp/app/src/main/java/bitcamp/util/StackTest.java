package bitcamp.util;

public class StackTest {

  public static void main(String[] args) {
    Stack<String> stack = new Stack<>();

    stack.push("aaa");
    stack.push("bbb");
    stack.push("ccc");

    while (!stack.empty()) {
      System.out.println(stack.pop());
      System.out.println(stack.pop());
    }


  }
}
