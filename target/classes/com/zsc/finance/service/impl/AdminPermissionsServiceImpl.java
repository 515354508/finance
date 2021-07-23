package com.zsc.finance.service.impl;

import com.zsc.finance.entity.AdminPermissions;
import com.zsc.finance.entity.AdminPermissionsExample;
import com.zsc.finance.mapper.AdminPermissionsMapper;
import com.zsc.finance.service.AdminPermissionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class AdminPermissionsServiceImpl implements AdminPermissionsService {
    @Autowired
    AdminPermissionsMapper adminPermissionsMapper;

    @Override
    public List<AdminPermissions> selectAdminPermissionsByAdminId(Integer adminId) {
        AdminPermissionsExample adminPermissionsExample = new AdminPermissionsExample();
        adminPermissionsExample.createCriteria().andAdminidEqualTo(adminId);
        return adminPermissionsMapper.selectByExampleWithAdminAndPermissions(adminPermissionsExample);
    }


    @Override
    @Transactional
    public Integer insertAdminPermissions(AdminPermissions adminPermissions) {
        return adminPermissionsMapper.insertSelective(adminPermissions);
    }

    @Override
    @Transactional
    public Integer UpdateAdminPermissions(AdminPermissions adminPermissions) {
        return adminPermissionsMapper.updateByPrimaryKeySelective(adminPermissions);
    }

    @Override
    @Transactional
    public Integer deleteAdminPermissionsByPermissionId(Integer permissionId) {
        AdminPermissionsExample adminPermissionsExample = new AdminPermissionsExample();
        adminPermissionsExample.createCriteria().andPermissionidEqualTo(permissionId);
        return adminPermissionsMapper.deleteByExample(adminPermissionsExample);
    }

    @Override
    public Integer deleteAllAdminPermissionsByAdminId(Integer adminId) {
        AdminPermissionsExample adminPermissionsExample = new AdminPermissionsExample();
        adminPermissionsExample.createCriteria().andAdminidEqualTo(adminId);
        return adminPermissionsMapper.deleteByExample(adminPermissionsExample);
    }
}
