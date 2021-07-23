package com.zsc.finance.service.impl;

import com.zsc.finance.entity.Bank;
import com.zsc.finance.mapper.BankMapper;
import com.zsc.finance.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BankServiceImpl implements BankService {
    @Autowired
    BankMapper bankMapper;

    @Override
    public List<Bank> selectAllBank() {
        List<Bank> list = bankMapper.selectByExample(null);
        return list;
    }

    @Override
    public Bank selectBankById(Integer id) {
        return bankMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    public Integer insertBank(Bank bank) {
        return bankMapper.insertSelective(bank);
    }

    @Override
    @Transactional
    public Integer updateBank(Bank bank) {
        return bankMapper.updateByPrimaryKeySelective(bank);
    }

    @Override
    @Transactional
    public Integer deleteBankById(Integer id) {
        return bankMapper.deleteByPrimaryKey(id);
    }
}
