package com.epdcblog.epdcblog.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epdcblog.epdcblog.entity.News;
import com.epdcblog.epdcblog.repository.NewsRepository;

@Service
public class NewsService {

    @Autowired
    private NewsRepository newsRepository;

    // Get all news for a specific category
    public List<News> getNewsByCategory(String category) {
        return newsRepository.findByCategory(category);
    }

     // Get the latest news for a specific category
     public News getLatestNewsByCategory(String category) {
        return newsRepository.findFirstByCategoryOrderByIdAsc(category);
    }
 
    public News getNewsById(String id) {
        return newsRepository.findById(id).orElse(null);
    }
 
}

