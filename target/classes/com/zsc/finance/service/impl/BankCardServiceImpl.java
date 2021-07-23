package com.zsc.finance.service.impl;

import com.zsc.finance.entity.Bankcard;
import com.zsc.finance.entity.BankcardExample;
import com.zsc.finance.mapper.BankcardMapper;
import com.zsc.finance.service.BankCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BankCardServiceImpl implements BankCardService {

    @Autowired
    BankcardMapper bankcardMapper;
    @Override
    public List<Bankcard> selectAllBankCard() {
        return bankcardMapper.selectByExampleWithUser(null);
    }

    @Override
    public List<Bankcard> selectBankCardByUserId(Integer userId) {
        BankcardExample bankcardExample = new BankcardExample();
        bankcardExample.createCriteria().andUseridEqualTo(userId);
        return bankcardMapper.selectByExampleWithUser(bankcardExample);
    }

    @Override
    public Bankcard selectBankCardById(Integer id) {
        return bankcardMapper.selectByPrimaryKeyWithUser(id);
    }

    @Override
    @Transactional
    public Integer insertBankCard(Bankcard bankcard) {
        return bankcardMapper.insertSelective(bankcard);
    }

    @Override
    @Transactional
    public Integer updateBankCard(Bankcard bankcard) {
        return bankcardMapper.updateByPrimaryKeySelective(bankcard);
    }

    @Override
    public Integer deleteBankCardById(Integer id) {
        return bankcardMapper.deleteByPrimaryKey(id);
    }
}
