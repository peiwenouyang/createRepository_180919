package com.divisible.web;

import com.divisible.service.DivisibleService;
import com.divisible.vo.BaseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @Autowired
    private DivisibleService divisibleService;
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public BaseData Home(){
        return divisibleService.changeBaseData();
    }
}
