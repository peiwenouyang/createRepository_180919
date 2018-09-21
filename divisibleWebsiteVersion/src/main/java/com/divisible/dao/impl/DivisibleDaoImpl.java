package com.divisible.dao.impl;

import com.divisible.dao.DivisibleDao;
import com.divisible.vo.BaseData;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class DivisibleDaoImpl implements DivisibleDao {
    @Override
    public BaseData changeBaseData() {
        BaseData base = new BaseData();
        int i = 0;
        List<String> list = base.getNumberList();
        int numberEnd = list.size();
        int numberBegin = 1;

        do{

            if(i%3 == 0 && i%5 != 0){
                list.set(i-1, "Fizz");
                i += 3;
            }else
            {
                i++;
            }

        }while (i <= numberEnd);
        i = numberBegin;
        do{
            if(i%5 == 0 && i%3!= 0){
                list.set(i-1, "Buzz");
                i += 5;
            }else
            {
                i++;
            }

        }while (i <= numberEnd);
        i = numberBegin;
        do{
            if(i%5 == 0&& i%3 == 0){
                list.set(i-1, "FizzBuzz");
                i += 15;
            }else
            {
                i++;
            }

        }while (i <= numberEnd);
        base.setNumberList(list);


        return base;
    }
}
