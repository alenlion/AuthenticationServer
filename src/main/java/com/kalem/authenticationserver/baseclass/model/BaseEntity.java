package com.kalem.authenticationserver.baseclass.model;

/**
 * @author Rayan Aksu
 * @since 7/27/2023
 */

public abstract class BaseEntity<I extends Number> extends CoreEntity{
    public abstract I getId();

    public abstract void setId( I id );

}
