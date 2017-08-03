package com.exercise.flattener.exception;

/**
 * Created by Saverio Morpurgo on 03/08/2017.
 *
 * Basic execption handling hierarchy
 */
public class FlattenException extends Exception {

    public FlattenException(final Throwable message) {
        super(message);
    }
}
