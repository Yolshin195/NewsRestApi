package ru.yolshin.NewsRestApi.service.common;

import ru.yolshin.NewsRestApi.entity.AbstractEntity;
import ru.yolshin.NewsRestApi.repository.CommonRepository;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.Optional;

public abstract class AbstractService<E extends AbstractEntity,  R extends CommonRepository<E>> implements CommonService<E> {

  private final R repository;

  public AbstractService(R repository) {
    this.repository = repository;
  }

  @Override
  public Optional<E> save(E entity) {
    return Optional.of(repository.save(entity));
  }

  @Override
  public List<E> getAll() {
    return Lists.newArrayList(repository.findAll());
  }

}

