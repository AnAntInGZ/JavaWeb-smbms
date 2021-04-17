package com.kuang.service.role;

import com.kuang.dao.BaseDao;
import com.kuang.dao.role.roleDao;
import com.kuang.dao.role.roleDaoImpl;
import com.kuang.pojo.Role;

import java.sql.Connection;
import java.util.List;

public class roleServiceImpl implements roleService{
    private com.kuang.dao.role.roleDao roleDao;
    public roleServiceImpl(){
        roleDao = new roleDaoImpl();
    }
    @Override
    public List<Role> getRoleList() {
        Connection connection = null;
        List<Role> roleList = null;
        try {
            connection = BaseDao.getConnection();
            roleList = roleDao.getRoleList(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return roleList;
    }
}
