package com.exercise.flattener;

import com.exercise.flattener.exception.FlattenException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by Saverio Morpurgo on 03/08/2017.
 */
public class IntegerFlattenerTest {

    private ArrayFlattener<Integer> flattener = new IntegerRecursiveFlattener();

    private Object[] inputNull = null;
    private Object[] inputEmpty = new Object[0];
    private Object[] inputInvalid = {9,"I am not an Integer"};
    private Object[] inputFlat = {1,4,5,7};
    private Object[] inputNestOneLevel = {new Object[]{1,4},5,7};
    private Object[] inputNestedMultipleLevel = {new Object[]{new Object[]{1,4},5},7};
    private Object[] inputMissorted = {new Object[]{new Object[]{1,5},4},7};

    private Integer[] expectedSorted = {1,4,5,7};
    private Integer[] expectedMissorted = {1,5,4,7};

    @Before
    public void before() {

    }

    @Test
    public void testFlattenNull() throws Exception {
        assertNull("null output", flattener.flatten(inputNull));
    }

    @Test
    public void testFlattenEmpty() throws Exception {
        assertArrayEquals("Empty output", new Integer[0], flattener.flatten(inputEmpty));
    }

    @Test(expected = FlattenException.class)
    public void testInvalidIntegerArray() throws Exception {
        flattener.flatten(inputInvalid);
    }

    @Test
    public void testSimple() throws FlattenException {
        assertArrayEquals("same arrays", expectedSorted, flattener.flatten(inputFlat));
    }

    @Test
    public void testNestedOneLevel() throws FlattenException {
        assertArrayEquals("same arrays", expectedSorted, flattener.flatten(inputNestOneLevel));
    }

    @Test
    public void testNestedMultipleLevels() throws FlattenException {
        assertArrayEquals("same arrays", expectedSorted, flattener.flatten(inputNestedMultipleLevel));
    }

    @Test
    public void testMissorted() throws FlattenException {
        assertArrayEquals("same arrays", expectedMissorted, flattener.flatten(inputMissorted));
    }
}