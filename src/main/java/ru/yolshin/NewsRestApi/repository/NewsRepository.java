package ru.yolshin.NewsRestApi.repository;

import org.springframework.stereotype.Repository;
import ru.yolshin.NewsRestApi.entity.News;

@Repository
public interface NewsRepository extends CommonRepository<News> {
} 
