package com.divisible.vo;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.ArrayList;
import java.util.List;

public class BaseData {
    @JSONField
    private List<String> numberList = new ArrayList<String>();
    public BaseData(){
        for(int i =0 ; i <=100; i++){
            numberList.add(String.valueOf(i));
        }
    }
    public List<String> getNumberList() {
        return numberList;
    }

    public void setNumberList(List<String> numberList) {

        this.numberList = numberList;
    }
}
