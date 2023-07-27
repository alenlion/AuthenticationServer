package com.kalem.authenticationserver.baseclass.service;

import com.kalem.authenticationserver.baseclass.model.CoreDto;
import com.kalem.authenticationserver.baseclass.model.CoreEntity;

/**
 * @author Rayan Aksu
 * @since 7/27/2023
 */

public interface BaseCrudService<I extends Number, T extends CoreEntity, D extends CoreDto> {
    public abstract T mapToEntity(D source, String mapId);

    public abstract D mapToDto(T source, String mapId);

    D create( D addressDto );

    D update( D addressDto );

    D getById( I id );

    boolean delete( I id );


}
