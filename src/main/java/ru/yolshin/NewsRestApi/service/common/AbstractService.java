package ru.yolshin.NewsRestApi.service.common;

import ru.yolshin.NewsRestApi.entity.AbstractEntity;
import ru.yolshin.NewsRestApi.repository.CommonRepository;
import com.google.common.collect.Lists;

import java.util.List;

public abstract class AbstractService<E extends AbstractEntity,  R extends CommonRepository<E>> implements CommonService<E> {

  private final R repository;

  public AbstractService(R repository) {
    this.repository = repository;
  }

  @Override
  public List<E> getAll() {
    return Lists.newArrayList(repository.findAll());
  }

}

