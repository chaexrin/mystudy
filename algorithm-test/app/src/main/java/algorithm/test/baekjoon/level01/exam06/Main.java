package algorithm.test.baekjoon.level01.exam06;

public class Main {
  public static void main(String[] args) {

    java.util.Scanner sc = new java.util.Scanner(System.in);
    int A = sc.nextInt();
    int B = sc.nextInt();


    if (1 <= A && B <= 10000) {
      System.out.println(A + B);
      System.out.println(A - B);
      System.out.println(A * B);
      System.out.println(A / B);
      System.out.println(A % B);
    }
  }
}
