package com.zsc.finance.service.impl;

import com.zsc.finance.entity.News;
import com.zsc.finance.mapper.NewsMapper;
import com.zsc.finance.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NewsServiceImpl implements NewsService {

    @Autowired(required = false)
    NewsMapper newsMapper;

    @Override
    public List<News> selectAllNews() {
        List<News> list = newsMapper.selectByExample(null);
        return list;
    }
}
