package algorithm.test.baekjoon.level01.exam10;

public class Main {

  public static void main(String[] args) {

    java.util.Scanner sc = new java.util.Scanner(System.in);

    int a = sc.nextInt();
    int b = sc.nextInt();

    System.out.println(a * (b % 10));
    System.out.println(a * (b / 10 % 10));
    System.out.println(a * (b / 100));
    System.out.println(a * b);
  }
}
