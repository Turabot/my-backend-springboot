package com.example.mybackendspringboot.mapper;

public interface Mapper<F, T> {

    T mapFrom(F object);
}
