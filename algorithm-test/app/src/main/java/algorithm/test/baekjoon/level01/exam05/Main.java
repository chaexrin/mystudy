package algorithm.test.baekjoon.level01.exam05;

public class Main {
  public static void main(String[] args) {

    java.util.Scanner sc = new java.util.Scanner(System.in);
    Double A = sc.nextDouble();
    Double B = sc.nextDouble();


    if (A > 0 && B < 10) {
      System.out.println(A / B);
    }
  }
}
