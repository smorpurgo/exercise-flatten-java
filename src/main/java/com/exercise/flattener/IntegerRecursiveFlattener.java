package com.exercise.flattener;

import org.apache.commons.lang3.ObjectUtils;

import java.util.*;

/**
 * Created by Saverio Morpurgo on 03/08/2017.
 */
public class IntegerRecursiveFlattener implements ArrayFlattener<Integer> {

    @Override
    public Integer[] flatten(Object[] nestedArray) {
        Integer[] flatOutput;
        if (nestedArray == null) {
            flatOutput = null;
        } else if (nestedArray.length == 0) {
            flatOutput = new Integer[0];
        } else {
            final Collection<Integer> flatCollection  =   new ArrayList<>();
            for (Object o : nestedArray) {
                if (o instanceof Integer) {
                    flatCollection.add((Integer) o);
                } else if (o instanceof Object[]) {
                    flatCollection.addAll(Arrays.asList(flatten((Object[]) o)));
                } else {
                    throw new IllegalArgumentException("Nested array contains other than integers [ " + ObjectUtils.toString(o) + "]");
                }
            }
            flatOutput = flatCollection.toArray(new Integer[flatCollection.size()]);
        }
        return flatOutput;
    }

}
