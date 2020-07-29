package ru.yolshin.NewsRestApi.service.common;

import ru.yolshin.NewsRestApi.entity.AbstractEntity;

import java.util.List;
import java.util.Optional;

public interface CommonService<E extends AbstractEntity> {

  Optional<E> save(E entity);

  List<E> getAll();

}
