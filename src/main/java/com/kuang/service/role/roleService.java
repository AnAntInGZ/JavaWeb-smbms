package com.kuang.service.role;

import com.kuang.pojo.Role;

import java.sql.Connection;
import java.util.List;

public interface roleService {
    //获取角色列表
    public List<Role> getRoleList();
}
