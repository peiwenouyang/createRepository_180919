package com.dpp.com.help.crp;


public class DivisibleByThree extends Handler {
    public String handleRequest(int i) {
        if (i%3 == 0 && i%5 != 0)
        {
            return "Fizz";
        }else {
            return getSuccessor().handleRequest(i);
        }

    }
}
