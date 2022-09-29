package com.msa.redis.demo.sbdata;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;

public class MocktioDemo {

    @Test
  public void mockTest(){
      //mock creation
      List mockedList = mock(List.class);

      //using mock object
      mockedList.add("one");
      mockedList.clear();

      //verification
      verify(mockedList).add("one");
      verify(mockedList).clear();
  }

  @Test
  public void spyTest(){
      List list = new LinkedList();
      List spy = spy(list);

      //optionally, you can stub out some methods:
      when(spy.size()).thenReturn(100);

      //using the spy calls *real* methods
      spy.add("one");
      spy.add("two");

      //prints "one" - the first element of a list
      System.out.println(spy.get(0));

      //size() method was stubbed - 100 is printed
      System.out.println(spy.size());

      //optionally, you can verify
      verify(spy).add("one");
      verify(spy).add("two");
  }

}
