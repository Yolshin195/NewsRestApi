package ru.yolshin.NewsRestApi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.yolshin.NewsRestApi.controller.common.AbstractController;
import ru.yolshin.NewsRestApi.service.NewsTypeService;
import ru.yolshin.NewsRestApi.entity.NewsType;

@RestController
@RequestMapping("/newsType")
public class NewsTypeController extends AbstractController<NewsType, NewsTypeService> {
  public NewsTypeController(NewsTypeService service) {
    super(service);
  }
}
