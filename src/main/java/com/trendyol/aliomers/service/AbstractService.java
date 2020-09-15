package com.trendyol.aliomers.service;

import java.util.List;

/**
 * @author aliomers on 14.09.2020
 */

public abstract class AbstractService<T> {

    abstract void add(T t);

    abstract void addAll(List<T> t);

    abstract void delete(T t);

    abstract List<T> list();

}
