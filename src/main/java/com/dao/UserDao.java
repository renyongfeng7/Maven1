package com.dao;

import com.bean.Role;
import com.bean.Root;
import com.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    public List<User> selectAll();
    /*用户登陆查询*/
    public User login(@Param("userName") String userName, @Param("userPwd") String userPwd);
    public Role selectRootByRealname(String realName);
    public User selectById(Integer id);
    public int deleteById(Integer id);
    public List<User> selectByPage(@Param("page") int page, @Param("pageSize") int pageSize);
    public int save(User obj);
    public int update(User user);
    /*通过角色查询权限*/
    public List<Root> selectByRole(int role);
}
