package ru.mirea.admin.mapper;


import org.mapstruct.Mapper;
import ru.mirea.admin.dto.UserDto;
import ru.mirea.admin.entity.UserEntity;

@Mapper
public abstract class UserMapper implements MapperInterface<UserEntity, UserDto> {
}
