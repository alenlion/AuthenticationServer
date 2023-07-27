package com.kalem.authenticationserver.user.service;

import com.kalem.authenticationserver.baseclass.service.BaseCrudService;
import com.kalem.authenticationserver.user.model.UserDto;
import com.kalem.authenticationserver.user.model.UserEntity;

/**
 * @author Rayan Aksu
 * @since 7/27/2023
 */

public class UserCrudService implements BaseCrudService<Integer, UserEntity, UserDto> {

    @Override
    public UserEntity mapToEntity( UserDto source, String mapId ) {
        return null;
    }

    @Override
    public UserDto mapToDto( UserEntity source, String mapId ) {
        return null;
    }

    @Override
    public UserDto create( UserDto addressDto ) {
        return null;
    }

    @Override
    public UserDto update( UserDto addressDto ) {
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
