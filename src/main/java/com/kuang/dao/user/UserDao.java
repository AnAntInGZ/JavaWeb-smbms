package com.kuang.dao.user;

import com.kuang.pojo.Role;
import com.kuang.pojo.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    //得到要登录的用户
    public User getLoginUser(Connection connection, String userCode) throws Exception;
    //修改当前用户密码
    public int updatePwd(Connection connection,String userCode,String password )throws Exception;
    //查询用户总数
    public int getUserCount(Connection connection,String username,int userRole)throws Exception;
    //获取用户列表
    public List<User> getUserList(Connection connection, String userName, int userRole, int currentPageNo, int pageSize)throws Exception;
    //添加用户
    public int addUser(Connection connection,User user)throws Exception;
    //通过id得到user
    public User getUserById(Connection connection,String id)throws Exception;
    //修改用户
    public int modifyUser(Connection connection,User user)throws Exception;
    //通过id删除user
    public int deleteUserById(Connection connection, Integer delId)throws Exception;
}
