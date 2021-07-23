package com.zsc.finance.mapper;

import com.zsc.finance.entity.FundProduct;
import com.zsc.finance.entity.FundProductExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FundProductMapper {
    long countByExample(FundProductExample example);

    int deleteByExample(FundProductExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FundProduct record);

    int insertSelective(FundProduct record);

    List<FundProduct> selectByExample(FundProductExample example);

    FundProduct selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FundProduct record, @Param("example") FundProductExample example);

    int updateByExample(@Param("record") FundProduct record, @Param("example") FundProductExample example);

    int updateByPrimaryKeySelective(FundProduct record);

    int updateByPrimaryKey(FundProduct record);
}