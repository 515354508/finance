package com.zsc.finance.service;

import com.zsc.finance.entity.Permissions;

import java.util.List;

public interface PermissionsService {

    List<Permissions> selectPermissionsByPermission(String permission);
}
