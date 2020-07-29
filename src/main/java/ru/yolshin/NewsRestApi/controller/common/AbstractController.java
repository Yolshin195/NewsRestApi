package ru.yolshin.NewsRestApi.controller.common;

import org.springframework.http.ResponseEntity;
import ru.yolshin.NewsRestApi.service.common.CommonService;
import ru.yolshin.NewsRestApi.entity.AbstractEntity;

import java.util.List;

public abstract class AbstractController<E extends AbstractEntity, S extends CommonService<E>> implements CommonController<E> {

  private final S service;

  protected AbstractController(S service) {
    this.service = service;
  }

  @Override
  public ResponseEntity<List<E>> getAll() {
    return ResponseEntity.ok(service.getAll());
  }
}
