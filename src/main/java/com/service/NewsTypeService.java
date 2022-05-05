package com.service;

import com.bean.NewsType;

import java.util.List;

public interface NewsTypeService {
    /*查询所有*/
    public List<NewsType> selectAll();
    /*通过id删除*/
    public int deleteById(int id);
    public int insert(NewsType newsType);


}
