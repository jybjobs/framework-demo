package com.sma.demo;

public class FinalField {

  public int i;
  public final int j;

  static FinalField obj;

  public FinalField(){
      i = 1;
      j = 2;
  }

  public static void writer(){  //线程A
        obj = new FinalField();
  }

  public static void reader(){
      FinalField object  = obj;
      int a = object.i;
      int b = object.j;
  }

}