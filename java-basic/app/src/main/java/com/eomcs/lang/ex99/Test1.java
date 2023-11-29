package com.eomcs.lang.ex99;

public class Test1 {

  public static void main(String[] args) throws Exception {
    java.io.InputStream in = System.in;
    java.util.Scanner KeyIn = new java.util.Scanner(in);
    String str = KeyIn.nextLine();
    System.out.println("==>" + str);
    KeyIn.close();
  }
}
