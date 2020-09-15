package com.trendyol.aliomers.creature;

import java.util.List;

/**
 * @author aliomers on 13.09.2020
 */

public abstract class AbstractCreature<T> {

    abstract List<T> getList();

    abstract void add(T t);

    abstract void delete(T t);

}
