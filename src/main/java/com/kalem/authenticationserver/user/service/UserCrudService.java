package com.kalem.authenticationserver.user.service;

import com.kalem.authenticationserver.baseclass.service.BaseCrudService;
import com.kalem.authenticationserver.user.mapper.UserMapper;
import com.kalem.authenticationserver.user.model.UserDto;
import com.kalem.authenticationserver.user.model.UserEntity;
import com.kalem.authenticationserver.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Rayan Aksu
 * @since 7/27/2023
 */

@RequiredArgsConstructor
@Service
public class UserCrudService implements BaseCrudService<Integer, UserEntity, UserDto> {
    private final UserRepository userRepository;

    @Override
    public UserEntity mapToEntity( UserDto source, String mapId ) {
        return UserMapper.INSTANCE.toEntity( source );
    }

    @Override
    public UserDto mapToDto( UserEntity source, String mapId ) {
        return UserMapper.INSTANCE.toDto( source );
    }

    @Override
    public UserDto create( UserDto user ) {

        return mapToDto( userRepository.save( mapToEntity( user, "" ) ), "" );
    }

    @Override
    public UserDto update( UserDto user ) {
        return null;
    }

    @Override
    public UserDto getById( Integer id ) {
        return null;
    }

    @Override
    public boolean delete( Integer id ) {
        return false;
    }
}
