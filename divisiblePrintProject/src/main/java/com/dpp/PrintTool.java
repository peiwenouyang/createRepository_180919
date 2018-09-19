package com.dpp;

import java.util.List;
/*
*helping to show data with line feed
 */
public class PrintTool {
    public static void seperateAndPrintList(List<String> list, int seperateLength){
        int listFrom = 0;
        int listTo = seperateLength;//each line should have how many data
        do{
            List<String> subList = list.subList(listFrom,listTo);
            System.out.println(subList);
            listFrom += seperateLength;
            listTo += seperateLength;
        }while (listTo < list.size());
        List<String> remainSubList = list.subList(listFrom,list.size());// if the rest of the is shorter than seperateLength
        System.out.println(remainSubList);
    }
}
