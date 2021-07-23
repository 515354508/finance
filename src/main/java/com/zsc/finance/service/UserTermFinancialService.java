package com.zsc.finance.service;

import com.zsc.finance.entity.UserTermFinancial;

import java.util.List;

public interface UserTermFinancialService {

    Integer insertUserTermFinancial(UserTermFinancial userTermFinancial);

    List<UserTermFinancial> selectUserTermFinancialByUserId(Integer userId);

    Integer updateUserTermFinancial(UserTermFinancial userTermFinancial);

    UserTermFinancial selectUserTermFinancialById(Integer id);
}
