package com.service.impl;

import com.bean.NewsInfor;
import com.dao.NewsInforDao;
import com.service.NewsInforService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional//事务
@Service()
public class NewsInforServiceImpl implements NewsInforService {

    @Autowired
    private NewsInforDao newsInforDao;
    @Override
    public List<NewsInfor> selectAll() {
        return newsInforDao.selectAll();
    }

    @Override
    public List<NewsInfor> selectByPage(int pageNo, int pageSize) {
        return newsInforDao.selectByPage(pageNo,pageSize);
    }

    @Override
    public int insert(NewsInfor newsInfor) {
        return newsInforDao.insert(newsInfor);
    }

    @Override
    public int deleteById(Integer id) {
        return newsInforDao.deleteById(id);
    }

    @Override
    public NewsInfor selectById(Integer id) {
        return newsInforDao.selectById(id);
    }

    @Override
    public int count() {
        return newsInforDao.count();
    }

    @Override
    public int updateById(NewsInfor newsInfor) {
        return newsInforDao.updateById(newsInfor);
    }
}
