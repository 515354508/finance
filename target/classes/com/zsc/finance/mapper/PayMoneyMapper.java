package com.zsc.finance.mapper;

import com.zsc.finance.entity.PayMoney;
import com.zsc.finance.entity.PayMoneyExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PayMoneyMapper {
    long countByExample(PayMoneyExample example);

    int deleteByExample(PayMoneyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PayMoney record);

    int insertSelective(PayMoney record);

    List<PayMoney> selectByExample(PayMoneyExample example);

    PayMoney selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PayMoney record, @Param("example") PayMoneyExample example);

    int updateByExample(@Param("record") PayMoney record, @Param("example") PayMoneyExample example);

    int updateByPrimaryKeySelective(PayMoney record);

    int updateByPrimaryKey(PayMoney record);
}