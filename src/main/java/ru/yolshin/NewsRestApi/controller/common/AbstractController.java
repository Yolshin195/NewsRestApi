package ru.yolshin.NewsRestApi.controller.common;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpStatus;
import ru.yolshin.NewsRestApi.service.common.CommonService;
import ru.yolshin.NewsRestApi.entity.AbstractEntity;
import ru.yolshin.NewsRestApi.exception.SampleException;
import ru.yolshin.NewsRestApi.base.ErrorType;

import java.util.List;

public abstract class AbstractController<E extends AbstractEntity, S extends CommonService<E>> implements CommonController<E> {

  private final S service;

  protected AbstractController(S service) {
    this.service = service;
  }

  @Override
  public ResponseEntity<E> get(@PathVariable("ID") Long id) {
    return service.get(id).map(ResponseEntity::ok)
      .orElseThrow(() -> new SampleException(
        String.format(ErrorType.ENTITY_NOT_FOUND.getDescription(), id)
    ));
  }

  @Override
  public ResponseEntity<List<E>> getAll() {
    return ResponseEntity.ok(service.getAll());
  }

  @Override
  public ResponseEntity<E> save(@RequestBody E entity) {
    return service.save(entity).map(ResponseEntity::ok)
      .orElseThrow(() -> new SampleException(
        String.format(ErrorType.ENTITY_NOT_SAVED.getDescription(), entity.toString())
      ));
  }

  @Override
  public ResponseEntity<E> update(@RequestBody E entity) {
    return service.update(entity).map(ResponseEntity::ok)
      .orElseThrow(() -> new SampleException(
        String.format(ErrorType.ENTITY_NOT_UPDATED.getDescription(), entity)
      ));
  }

  @Override
  public Boolean delete(@PathVariable("ID") Long id) {
    return service.deleteById(id);
  }
}
