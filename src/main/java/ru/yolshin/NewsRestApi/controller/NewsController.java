package ru.yolshin.NewsRestApi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.yolshin.NewsRestApi.controller.common.AbstractController;
import ru.yolshin.NewsRestApi.service.NewsService;
import ru.yolshin.NewsRestApi.entity.News;

@RestController
@RequestMapping("/news")
public class NewsController extends AbstractController<News, NewsService> {
  public NewsController(NewsService service) {
    super(service);
  }
}
