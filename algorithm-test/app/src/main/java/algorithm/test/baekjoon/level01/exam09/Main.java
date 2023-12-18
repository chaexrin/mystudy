package algorithm.test.baekjoon.level01.exam09;

public class Main {

  public static void main(String[] args) {

    java.util.Scanner sc = new java.util.Scanner(System.in);

    int A;
    int B;
    int C;

    A = sc.nextInt();
    B = sc.nextInt();
    C = sc.nextInt();


    System.out.println((A + B) % C);
    System.out.println(((A % C) + (B % C)) % C);
    System.out.println((A * B) % C);
    System.out.println(((A % C) * (B % C)) % C);
  }

}
