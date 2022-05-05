package com.dao;

import com.bean.NewsInfor;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface NewsInforDao {
    /*查询所有*/
    public List<NewsInfor> selectAll();
    /*分页查询*/
    public List<NewsInfor> selectByPage(@Param("pageNo") int pageNo, @Param("pageSize") int pageSize);//两个以上参数
    /*添加*/
    public int insert(NewsInfor newsInfor);
    /*根据id删除*/
    public int deleteById(Integer id);
    /*根据id查询*/
    public NewsInfor selectById(Integer id);
    /*总条数*/
    public int count();
    /*根据id更新*/
    public int updateById(NewsInfor infor);
}
