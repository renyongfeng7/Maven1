package com.dao;

import com.bean.NewsType;

import java.util.List;

public interface NewsTypeDao {

    /*查询所有*/
    public List<NewsType> selectAll();
    /*通过id删除*/
    public int deleteById(int id);
    /*类型添加*/
    public int insert(NewsType newsType);

}
