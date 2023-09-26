package com.teladoc.teladocJavaTest.models;

import com.teladoc.teladocJavaTest.exceptions.InvalidNaturalNumberException;
import com.teladoc.teladocJavaTest.exceptions.InvalidNegativeNumberException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * This class represents a Natural Number and stores it in the property named values as a reversed list
 * <pre>a given number like this => 123 it stores in a list like this => [3,2,1]</pre>
 * @author tom
 */
public class NaturalNumber {

    public static NaturalNumber ZERO = build("0");

    List<Integer> values;

    private NaturalNumber(List<Integer> values) {
        this.values = values;
    }

    /**
     *
     * @param index
     * @return returns the number stored at the given index if the index is outbounds of the list returns zero
     */
    private Integer getValueAt(int index) {
        return index >= 0 && index < values.size() ? values.get(index) : 0;
    }

    /**
     * Returns a new NaturalNumber with the addition of the param to this
     * <pre>Example: NaturalNumber.build("12").sum(NaturalNumber.build("123")) => NaturalNumber.build("135")</pre>
     * <pre>The addition is done term by term i.e [0+1, 1+2, 2+3] (in the example above)</pre>
     * @param other NaturalNumber to be sum to this
     * @return a NaturalNumber containing the result in a reversed list it stores in the property named value
     */
    public NaturalNumber sum(NaturalNumber other){
        int biggerSize = Math.max(values.size(), other.values.size());
        List<Integer> result = new ArrayList<>(biggerSize+1);
        int remaining = 0;
        for (int i = 0; i <= biggerSize; i++) {
            Integer addition = this.getValueAt(i) + other.getValueAt(i) + remaining;
            if(addition >= 10){
                addition = addition - 10;
                remaining = 1;
            } else {
                remaining = 0;
            }
            result.add(i, addition);
        }
        if(result.get(result.size() - 1) == 0) {
            result.remove(result.size() - 1);
        }
        return new NaturalNumber(result);
    }

    /**
     * Returns a NaturalNumber containing the number in a reversed list
     * @apiNote NaturalNumber.build("123") returns an instance of NaturalNumber with value as [3,2,1]
     * @param number a natural number as a String
     * @return NaturalNumber with the number in a list
     * @throws InvalidNegativeNumberException if the number starts with -
     * @throws InvalidNaturalNumberException if the String param is not a number
     */
    public static NaturalNumber build(String number){
        try {
            return new NaturalNumber(Arrays.stream(new StringBuilder(number).reverse().toString().split(""))
                    .map(Integer::parseInt).collect(Collectors.toList()));
        } catch (Exception e){
            if(number != null && number.startsWith("-")) {
                throw new InvalidNegativeNumberException("Negative numbers are not allowed");
            }
            throw new InvalidNaturalNumberException("This <<"+number+">> number is not allowed", e);
        }
    }

    /**
     * @return the string of the value e.g.
     * <pre> if value is [3, 2, 1] the toString method returns 123 </pre>
     */
    @Override
    public String toString(){
        return new StringBuilder(values.stream().map(String::valueOf).collect(Collectors.joining("")))
                .reverse().toString();
    };

    /**
     *
     * @param o an instance of NaturalNumber
     * @return the equality by toString method
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NaturalNumber that = (NaturalNumber) o;
        return Objects.equals(this.toString(), that.toString());
    }

}
