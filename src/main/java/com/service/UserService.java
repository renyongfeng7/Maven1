package com.service;

import com.bean.Role;
import com.bean.Root;
import com.bean.User;

import java.util.List;

public interface UserService  {
    public List<User> selectAll();
    public int save(User obj);
    public User login(String userName, String userPwd);
    public List<User> selectByPage(int page, int pageSize);
    public int deleteById(Integer id);
    public User selectById(Integer id);
    public int update(User user);
    /*登陆成功后查询用户权限*/
    public Role selectRootByRealname(String realName);
    public List<Root> selectByRole(int role);

}
