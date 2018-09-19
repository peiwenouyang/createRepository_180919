package com.dpp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.*;

import static com.dpp.DivisibleMethodCollection.getDivisibleListByAddList;

/*
*Write a program that prints the number from 1 to 100. But for multiples of three print "Fizz"
* instead of the number and for the multiples of five print "Buzz". For numbers which are multiples of both three
* and five print "FizzBuzz"
* Here is all the method which can realize, and I try to every possible solution,some may not good in a way
 */

public class DivisibleMethodCollection {
    /*the base solution to this problem,every turn try to add one sequence number to numberList
    * then, verdict it can be divisible by 3 or 5 or (3 and 5), true change data to 'Fizz',
    * 'Buzz', 'FizzBuzz'*/
    public static List<String> getDivisibleListByAddList(int numberBegin, int numberEnd ){
        List<String> numberList = new ArrayList<String>();

        if(numberBegin > numberEnd){
          return  numberList;
        }

        int i = numberBegin;
        do{
            if (i%3 == 0 && i%5 != 0)
            {
                numberList.add("Fizz");
            }
            if (i%3 != 0 && i%5 == 0)
            {
                numberList.add("Buzz");
            }
            if (i%3 == 0 && i%5 == 0)
            {
                numberList.add("FizzBuzz");
            }
            if (i%3 != 0 && i%5 != 0)
            {
                numberList.add(String.valueOf(i));
            }
            i++;
        }while ( i <= numberEnd );
        return numberList;
    }
    /*use multiple Thread to solve the problem, may not effective in low level data scale*/
    public static List<String> getDivisibleListByMultiThread(int numberBegin, int numberEnd, int missionNumber)
            throws ExecutionException, InterruptedException{
        ExecutorService execPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        int totalNumber = numberEnd - numberBegin+1;
        int singleListLength = totalNumber/missionNumber-1;
        int remainListLength = totalNumber%missionNumber;
        int taskEnd = numberBegin + singleListLength;
        int taskBegin = numberBegin;
        List<String> futureList = new ArrayList<String>();
        //if the data set have more than some number,then multiple Thread is working ,the temp number set 100
        if(numberBegin > numberEnd){
            return  futureList;
        }else if(totalNumber < 100 )
        {
            return getDivisibleListByAddList(numberBegin,numberEnd);
        }

        while (taskEnd <= totalNumber - remainListLength+1) {
            Future<List<String>> list = execPool.submit(new DivisibleCallable(taskBegin, taskEnd));
            futureList.addAll(list.get());
            taskBegin = taskEnd + 1;
            taskEnd = taskBegin + singleListLength;
        }

        if(taskBegin < totalNumber){
            futureList.addAll( getDivisibleListByAddList(taskBegin, taskBegin+remainListLength));

        }else if(taskBegin == totalNumber){
            futureList.addAll(getDivisibleListByAddList(taskBegin,taskBegin));
        }
        execPool.shutdown();
        return futureList;
    }
}


class DivisibleCallable implements Callable<List<String>> {

    private int begin;
    private int end;
    DivisibleCallable(int begin, int end)
    {
        this.begin = begin;
        this.end = end;
    }
    public List<String> call() throws Exception{
        return getDivisibleListByAddList(begin,end);
    }
}