package com.exercise.flattener;

/**
 * Created by Saverio Morpurgo on 03/08/2017.
 */
public interface ArrayFlattener<K> {

    K[] flatten(Object[] nestedArray);
}
