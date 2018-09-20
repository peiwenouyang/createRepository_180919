package com.dpp;

import org.junit.Test;

import java.util.List;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.*;

public class DivisibleMethodCollectionTest {

    @Test
    public void getDivisibleListByAddListOnRightCase() {
      List<String> testList =  DivisibleMethodCollection.getDivisibleListByAddList(1,100);
      assertEquals(100,testList.size());
      int size = testList.size();
      for(int i = 0; i<size; i++)
      {
          if((i+1)%3 == 0 && (i+1)%5 != 0){ assertEquals("Fizz",testList.get(i));}
          if((i+1)%3 != 0 && (i+1)%5 == 0){ assertEquals("Buzz",testList.get(i));}
          if((i+1)%3 == 0 && (i+1)%5 == 0){ assertEquals("FizzBuzz",testList.get(i));}
          if((i+1)%3 != 0 && (i+1)%5 != 0){
              assertNotEquals("Fizz", testList.get(i));
              assertNotEquals("Buzz", testList.get(i));
              assertNotEquals("FizzBuzz", testList.get(i));
              assertEquals(String.valueOf(i+1), testList.get(i));
          }
      }
    }

    @Test
    public void getDivisibleListByAddListOnSameParameter(){
        List<String> testList = DivisibleMethodCollection.getDivisibleListByAddList(6,6);
        assertEquals(1,testList.size());
        assertEquals("Fizz",testList.get(0));

        List<String> testList2 = DivisibleMethodCollection.getDivisibleListByAddList(10,10);
        assertEquals(1,testList2.size());
        assertEquals("Buzz",testList2.get(0));

        List<String> testList3 = DivisibleMethodCollection.getDivisibleListByAddList(15,15);
        assertEquals(1,testList3.size());
        assertEquals("FizzBuzz",testList3.get(0));
    }

    @Test
    public void getDivisibleListByAddListBeginOutOfEnd() throws InterruptedException,ExecutionException{
        List<String> testList = DivisibleMethodCollection.getDivisibleListByAddList(8,6);
        assertEquals(0, testList.size());

    }


    @Test
    public void getDivisibleListByMultiThreadOnRightCase() throws InterruptedException,ExecutionException{
        List<String> testList =  DivisibleMethodCollection.getDivisibleListByMultiThread(1,100,3);
        assertEquals(100,testList.size());
        int size = testList.size();
        for(int i = 0; i<size; i++)
        {
            if((i+1)%3 == 0 && (i+1)%5 != 0){ assertEquals("Fizz",testList.get(i));}
            if((i+1)%3 != 0 && (i+1)%5 == 0){ assertEquals("Buzz",testList.get(i));}
            if((i+1)%3 == 0 && (i+1)%5 == 0){ assertEquals("FizzBuzz",testList.get(i));}
            if((i+1)%3 != 0 && (i+1)%5 != 0){
                assertNotEquals("Fizz", testList.get(i));
                assertNotEquals("Buzz", testList.get(i));
                assertNotEquals("FizzBuzz", testList.get(i));
                assertEquals(String.valueOf(i+1), testList.get(i));
            }
        }
    }

    @Test
    public void getDivisibleListByMultiThreadOnSameParameter() throws InterruptedException,ExecutionException{
        List<String> testList = DivisibleMethodCollection.getDivisibleListByMultiThread(6,6,3);
        assertEquals(1,testList.size());
        assertEquals("Fizz",testList.get(0));

        List<String> testList2 = DivisibleMethodCollection.getDivisibleListByMultiThread(10,10,3);
        assertEquals(1,testList2.size());
        assertEquals("Buzz",testList2.get(0));

        List<String> testList3 = DivisibleMethodCollection.getDivisibleListByMultiThread(15,15,3);
        assertEquals(1,testList3.size());
        assertEquals("FizzBuzz",testList3.get(0));
    }

    @Test
    public void getDivisibleListByMultiThreadBeginOutOfEnd() throws InterruptedException,ExecutionException{
        List<String> testList = DivisibleMethodCollection.getDivisibleListByMultiThread(8,6,3);
        assertEquals(0, testList.size());

    }


}