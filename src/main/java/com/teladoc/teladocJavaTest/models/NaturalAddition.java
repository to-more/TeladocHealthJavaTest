package com.teladoc.teladocJavaTest.models;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * This class represents a natural addition by receiving a
 * List of NaturalNumber and returning a NaturalNumber as the result
 * @author tom
 */
public class NaturalAddition implements ArithmeticOperation<List<NaturalNumber>, NaturalNumber> {

    /**
     *
     * @param numbers a list of NaturalNumber
     * @return a reduction from zero by calling sum on every NaturalNumber contained in the list
     */
    @Override
    public NaturalNumber execute(List<NaturalNumber> numbers) {
        return numbers.stream().reduce(NaturalNumber.ZERO, NaturalNumber::sum);
    }

    /**
     * Receives two numbers as a string and returns the result of execute method
     * @param number
     * @param other
     * @return the addition of the two given numbers as a string
     */
    public String addNumbers(String number, String other){
        return execute(Stream.of(number, other).map(NaturalNumber::build).collect(Collectors.toList())).toString();
    }
}
