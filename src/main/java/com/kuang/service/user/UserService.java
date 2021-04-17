package com.kuang.service.user;

import com.kuang.pojo.User;
import com.mysql.cj.util.StringUtils;

import java.sql.Connection;
import java.util.List;

public interface UserService {
    //用户登录
    public User login(String userCode, String password);

    //修改密码
    public boolean updatePwd(String userCode, String password);

    //查询记录数
    public int getUserCount(String username,int userRole);

    //根据条件查询用户列表
    public List<User> getUserList(String queryUserName, int queryUserRole, int currentPageNo, int pageSize);

    public boolean addUser(User user);
    //根据userCode得到user
    public User selectUserCodeExist(String userCode);
    //根据id得到user
    public User getUserById(String id);

    //修改用户
    public Boolean modifyUser(User user);

    //通过id删除user
    public boolean deleteUserById(Integer delId);
}
