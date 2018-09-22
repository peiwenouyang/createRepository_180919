package com.dpp.com.help.crp;


public class DivisibleByFifteen extends Handler {
    public String handleRequest(int i) {
        if (i%3 == 0 && i%5 != 0)
        {
            return "FizzBuzz";
        }else {
            return String.valueOf(i);
        }

    }
}
