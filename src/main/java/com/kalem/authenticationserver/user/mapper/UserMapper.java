package com.kalem.authenticationserver.user.mapper;


import com.kalem.authenticationserver.user.model.UserDto;
import com.kalem.authenticationserver.user.model.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper( uses = { AuthorityMapper.class } )
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );


    UserDto toDto( UserEntity source );


    @Mappings( {
            @Mapping( target = "authorities", ignore = true )
    } )
    UserEntity toEntity( UserDto source );
}
