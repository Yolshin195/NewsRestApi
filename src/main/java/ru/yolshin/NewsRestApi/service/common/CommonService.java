package ru.yolshin.NewsRestApi.service.common;

import ru.yolshin.NewsRestApi.entity.AbstractEntity;

import java.util.List;

public interface CommonService<E extends AbstractEntity> {

  List<E> getAll();

}
