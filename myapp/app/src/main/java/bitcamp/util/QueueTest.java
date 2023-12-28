package bitcamp.util;

public class QueueTest {

  public static void main(String[] args) {

    Queue<String> queue = new Queue<>();

    queue.offer("aaa");
    queue.offer("bbb");
    queue.offer("ccc");

    System.out.println(queue.poll());
    System.out.println(queue.peek());

  }
}
