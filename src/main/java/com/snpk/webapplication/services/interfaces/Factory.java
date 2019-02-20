package com.snpk.webapplication.services.interfaces;

public interface Factory<T, E extends Enum<?>> {
    T getObject(E e) throws Exception;
    Class<?> getObjectType();
    boolean isSingleton();
}

