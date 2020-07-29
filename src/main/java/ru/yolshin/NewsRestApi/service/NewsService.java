package ru.yolshin.NewsRestApi.service;

import org.springframework.stereotype.Service;
import ru.yolshin.NewsRestApi.entity.News;
import ru.yolshin.NewsRestApi.repository.NewsRepository;
import ru.yolshin.NewsRestApi.service.common.AbstractService;


@Service
public class NewsService extends AbstractService<News, NewsRepository> {

  public NewsService(NewsRepository repository) {
    super(repository);
  }
}
