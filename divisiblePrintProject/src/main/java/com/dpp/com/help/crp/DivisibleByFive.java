package com.dpp.com.help.crp;


public class DivisibleByFive extends Handler {
    public String handleRequest(int i) {
        if (i%3 != 0 && i%5 == 0)
        {
            return "Buzz";
        }else {
            return getSuccessor().handleRequest(i);
        }

    }
}
