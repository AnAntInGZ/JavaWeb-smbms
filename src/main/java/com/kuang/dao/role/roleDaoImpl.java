package com.kuang.dao.role;

import com.kuang.dao.BaseDao;
import com.kuang.pojo.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class roleDaoImpl implements roleDao{
    //获取角色列表
    @Override
    public List<Role> getRoleList(Connection connection) throws Exception {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Role> roleList = new ArrayList<>();
        if(connection!=null){
            String sql ="select * from smbms_role";
            Object[] params = {};
            rs = BaseDao.execute(connection, sql, params, rs, pstm);
            while(rs.next()){
                Role role = new Role();
                role.setRoleName(rs.getString("roleName"));
                role.setId(rs.getInt("id"));
                role.setRoleCode(rs.getString("roleCode"));
                roleList.add(role);
            }
            BaseDao.closeResource(null,pstm,rs);
        }
        return roleList;
    }

}
