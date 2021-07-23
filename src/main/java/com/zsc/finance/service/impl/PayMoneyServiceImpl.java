package com.zsc.finance.service.impl;

import com.zsc.finance.entity.PayMoney;
import com.zsc.finance.mapper.PayMoneyMapper;
import com.zsc.finance.service.PayMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PayMoneyServiceImpl implements PayMoneyService {

    @Autowired
    PayMoneyMapper payMoneyMapper;
    @Override
    public List<PayMoney> selectAllPayMoney() {
        List<PayMoney> list = payMoneyMapper.selectByExample(null);
        return list;
    }

    @Override
    public PayMoney selectPayMoneyById(Integer id) {
        PayMoney payMoney = payMoneyMapper.selectByPrimaryKey(id);
        return payMoney;
    }

    @Override
    @Transactional
    public Integer insertPayMoney(PayMoney payMoney) {
        return payMoneyMapper.insertSelective(payMoney);
    }

    @Override
    @Transactional
    public Integer updatePayMoney(PayMoney payMoney) {
        return payMoneyMapper.updateByPrimaryKeySelective(payMoney);
    }

    @Override
    @Transactional
    public Integer deletePayMoneyById(Integer id) {
        return payMoneyMapper.deleteByPrimaryKey(id);
    }
}
