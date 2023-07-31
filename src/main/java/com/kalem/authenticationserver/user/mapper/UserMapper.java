package com.kalem.authenticationserver.user.mapper;


import com.kalem.authenticationserver.user.model.UserDto;
import com.kalem.authenticationserver.user.model.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );


    UserDto toDto( UserEntity source );


    UserEntity toEntity( UserDto source );
}
