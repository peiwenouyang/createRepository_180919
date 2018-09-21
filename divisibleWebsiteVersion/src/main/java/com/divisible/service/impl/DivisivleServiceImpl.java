package com.divisible.service.impl;

import com.divisible.dao.DivisibleDao;
import com.divisible.dao.impl.DivisibleDaoImpl;
import com.divisible.service.DivisibleService;
import com.divisible.vo.BaseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class DivisivleServiceImpl implements DivisibleService{
    @Autowired
    private DivisibleDao dao;
    @Override
    public BaseData changeBaseData() {
        return dao.changeBaseData();
    }
}
