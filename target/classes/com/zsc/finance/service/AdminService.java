package com.zsc.finance.service;

import com.zsc.finance.entity.Admin;

public interface AdminService {

    Admin selectAdminByTerms(String username, String password);

    Integer updateAdmin(Admin admin);

    Admin selectAdminById(Integer id);
}
