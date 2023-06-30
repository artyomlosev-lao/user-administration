package ru.mirea.admin.mapper;

import java.util.List;

public interface MapperInterface<E, D> {

    D entityToDto(E entity);

    E dtoToEntity(D dto);

    List<D> toDtoList(List<E> entityList);

    List<E> toEntityList(List<D> dtoList);
}
