package ru.yolshin.NewsRestApi.service;

import org.springframework.stereotype.Service;
import ru.yolshin.NewsRestApi.entity.NewsType;
import ru.yolshin.NewsRestApi.repository.NewsTypeRepository;
import ru.yolshin.NewsRestApi.service.common.AbstractService;


@Service
public class NewsTypeService extends AbstractService<NewsType, NewsTypeRepository> {

  public NewsTypeService(NewsTypeRepository repository) {
    super(repository);
  }
}
