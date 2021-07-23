package com.zsc.finance.mapper;

import com.zsc.finance.entity.FlowOfFunds;
import com.zsc.finance.entity.FlowOfFundsExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FlowOfFundsMapper {
    long countByExample(FlowOfFundsExample example);

    int deleteByExample(FlowOfFundsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FlowOfFunds record);

    int insertSelective(FlowOfFunds record);

    List<FlowOfFunds> selectByExample(FlowOfFundsExample example);

    FlowOfFunds selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FlowOfFunds record, @Param("example") FlowOfFundsExample example);

    int updateByExample(@Param("record") FlowOfFunds record, @Param("example") FlowOfFundsExample example);

    int updateByPrimaryKeySelective(FlowOfFunds record);

    int updateByPrimaryKey(FlowOfFunds record);
}