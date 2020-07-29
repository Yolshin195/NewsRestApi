package ru.yolshin.NewsRestApi.controller.common;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.yolshin.NewsRestApi.entity.AbstractEntity;

import java.util.List;

public interface CommonController<E extends AbstractEntity> {

  //@PostMapping
  //ResponseEntity<E> save(@RequestBody E entity);

  //@GetMapping
  //ResponseEntity<E> get(@RequestParam Longid);

  @GetMapping("/all")
  ResponseEntity<List<E>> getAll();
}
