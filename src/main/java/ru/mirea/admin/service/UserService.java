package ru.mirea.admin.service;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mirea.admin.dto.UserDto;
import ru.mirea.admin.entity.UserEntity;
import ru.mirea.admin.mapper.UserMapper;
import ru.mirea.admin.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    public List<UserDto> getList() {
        return userMapper.toDtoList(userRepository.findAll());
    }

    public UserDto get(String id) {
        Optional<UserEntity> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) return userMapper.entityToDto(optionalUser.get());
        else return null;
    }

    public void save(UserDto userDto) {
        userRepository.save(userMapper.dtoToEntity(userDto));
    }

    public void deleted(String id) {
        userRepository.deleteById(id);
    }

}
