package ru.yolshin.NewsRestApi.service.common;

import ru.yolshin.NewsRestApi.entity.AbstractEntity;
import ru.yolshin.NewsRestApi.repository.CommonRepository;
import ru.yolshin.NewsRestApi.base.ErrorType;
import ru.yolshin.NewsRestApi.exception.SampleException;
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
  public Optional<E> get(Long id) {
    return repository.findById(id);
  }

  @Override
  public List<E> getAll() {
    return Lists.newArrayList(repository.findAll());
  }

  @Override
  public Optional<E> update(E entity) {
    return Optional.of(repository.save(entity));
  }
  
  @Override
  public Boolean deleteById(Long id) {
    E entity = get(id)
      .orElseThrow(() -> new SampleException(String.format(ErrorType.ENTITY_NOT_FOUND.getDescription(), id)));

    repository.delete(entity);

    return !repository.findById(entity.getId()).isPresent();
  }

}

