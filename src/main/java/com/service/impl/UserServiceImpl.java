package com.service.impl;

import com.bean.Role;
import com.bean.Root;
import com.bean.User;
import com.dao.UserDao;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Transactional
@Service ("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public User login(String userName, String userPwd) {
        System.out.println("实现类");
        System.out.println(userName+userPwd);
        return userDao.login(userName,userPwd);
    }
    
    @Override
    public List<User> selectByPage(int page, int pageSize) {
        return userDao.selectByPage(page,pageSize);
    }

    @Override
    public int deleteById(Integer id) {
        return userDao.deleteById(id);
    }

    @Override
    public User selectById(Integer id) {
        return userDao.selectById(id);
    }

    @Override
    public int update(User user) {
        return userDao.update(user);
    }

    @Override
    public Role selectRootByRealname(String realName) {
        return userDao.selectRootByRealname(realName);
    }

    @Override
    public List<Root> selectByRole(int role) {
        return userDao.selectByRole(role);
    }

    @Override
    public List<User> selectAll(){
        return userDao.selectAll();
    }

    @Override
    public int save(User obj) {
        return userDao.save(obj);
    }

















    /*!!!!!!!!!!!不要在业务逻辑层try catch!!!!!!!!!!!*/
   /* public int save(User obj){
     *//*模拟timeout，如果超时，则事务都不提交*//*
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
            userDao.save(obj);
            userDao.save(obj);
            return 1;
         *//*！！！！！！！！想要处理异常最后必须把异常抛出*//*
        *//*try{
            userDao.save(obj);
            userDao.save(obj);
            return 1;
        }catch(Exception e){
            throw e;
        }*//*
    }*/


}
