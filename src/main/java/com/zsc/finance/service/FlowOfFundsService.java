package com.zsc.finance.service;

import com.zsc.finance.entity.FlowOfFunds;

import java.util.List;

public interface FlowOfFundsService {

    Integer insertFlowOfFunds(FlowOfFunds flowOfFunds);

    List<FlowOfFunds> selectFlowOfFundsByUserId(Integer userId);
}
