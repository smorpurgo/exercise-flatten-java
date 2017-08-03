package com.exercise.flattener;

import com.exercise.flattener.exception.FlattenException;

/**
 * Flatten a generic nested array returning a flat array of type K
 * Nested arrays within the root array MUST be of type K
 * @param <K>
 */
public interface ArrayFlattener<K> {

    K[] flatten(Object[] nestedArray) throws FlattenException;
}
