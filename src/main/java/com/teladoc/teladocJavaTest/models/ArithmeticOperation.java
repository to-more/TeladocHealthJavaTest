package com.teladoc.teladocJavaTest.models;

/**
 * This interface is an abstraction of an arithmetic operation
 * @author tom
 */
public interface ArithmeticOperation<I, O> {

    /**
     * <pre>This method is intended to represent de execution of the arithmetic operation class</pre>
     * <pre>Receives an input and return an output</pre>
     * @param input to be executed
     * @return O as the output of the arithmetic operation execution
     */
    O execute(I input);
}
