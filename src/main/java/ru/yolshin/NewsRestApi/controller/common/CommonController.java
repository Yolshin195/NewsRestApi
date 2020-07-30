package ru.yolshin.NewsRestApi.controller.common;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.yolshin.NewsRestApi.entity.AbstractEntity;

import java.util.List;

public interface CommonController<E extends AbstractEntity> {

  @PostMapping
  ResponseEntity<E> save(@RequestBody E entity);

  @GetMapping("/{ID}")
  ResponseEntity<E> get(@PathVariable("ID") Long id);

  @GetMapping
  ResponseEntity<List<E>> getAll();

  @PutMapping
  ResponseEntity<E> update(@RequestBody E entity);

  @DeleteMapping("/{ID}")
  Boolean delete(@PathVariable("ID") Long id);
}
