package com.kuang.dao.role;

import com.kuang.pojo.Role;

import java.sql.Connection;
import java.util.List;

public interface roleDao {
    //获取角色列表
    public List<Role> getRoleList(Connection connection)throws Exception;
}
