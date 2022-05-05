package com.service.impl;

import com.bean.NewsType;
import com.dao.NewsTypeDao;
import com.service.NewsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional//事务
@Service()
public class NewsTypeServiceImpl implements NewsTypeService {
    @Autowired
    private NewsTypeDao newsTypeDao;
    @Override
    public List<NewsType> selectAll() {
        return newsTypeDao.selectAll();
    }
    @Override
    public int deleteById(int id) {
        return newsTypeDao.deleteById(id);
    }
    @Override
    public int insert(NewsType newsType) {
        return newsTypeDao.insert(newsType);
    }
}
