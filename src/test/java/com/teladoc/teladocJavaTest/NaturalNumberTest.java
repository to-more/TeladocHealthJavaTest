package com.teladoc.teladocJavaTest;

import com.teladoc.teladocJavaTest.exceptions.InvalidNaturalNumberException;
import com.teladoc.teladocJavaTest.exceptions.InvalidNegativeNumberException;
import com.teladoc.teladocJavaTest.models.NaturalNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NaturalNumberTest {

    @Test
    public void whenAddTwoNumbersThatOverflowUnityShouldReturnNewNaturalNumberWithTheSum() {
        NaturalNumber naturalNumber = NaturalNumber.build("9");
        NaturalNumber otherNaturalNumber = NaturalNumber.build("1");
        assertEquals(naturalNumber.sum(otherNaturalNumber), NaturalNumber.build("10"));
        assertEquals(NaturalNumber.build("19").sum(NaturalNumber.build("1")),
                NaturalNumber.build("20"));
    }

        @Test
    public void whenAddTwoNumbersShouldReturnNewNaturalNumberWithTheSum(){
        NaturalNumber naturalNumber      = NaturalNumber.build("12");
        NaturalNumber otherNaturalNumber = NaturalNumber.build("1");

        NaturalNumber a1 = NaturalNumber.build("123456789012345678901");
        NaturalNumber b1 = NaturalNumber.build("12345678");

        NaturalNumber a2 = NaturalNumber.build("123");
        NaturalNumber b2 = NaturalNumber.build("11");

        assertEquals(a1.sum(b1), NaturalNumber.build("123456789012358024579"));
        assertEquals(a2.sum(b2), NaturalNumber.build("134"));
        assertEquals(naturalNumber.sum(otherNaturalNumber), NaturalNumber.build("13"));
    }

    @Test
    public void whenApplyCommutationShouldReturnTheSameResult(){
        NaturalNumber naturalNumber      = NaturalNumber.build("12");
        NaturalNumber otherNaturalNumber = NaturalNumber.build("1");
        assertEquals(naturalNumber.sum(otherNaturalNumber), otherNaturalNumber.sum(naturalNumber));
    }

    @Test
    public void whenApplyAssociationShouldReturnTheSameResult(){
        NaturalNumber twelve = NaturalNumber.build("12");
        NaturalNumber one    = NaturalNumber.build("1");
        NaturalNumber two    = NaturalNumber.build("2");
        assertEquals(twelve.sum(one.sum(two)), twelve.sum(one).sum(two));
    }

    @Test
    public void whenBuildNegativeNumberShouldThrowException(){
        Exception expectedException = assertThrows(InvalidNegativeNumberException.class,
                () -> NaturalNumber.build("-123"));
        assertEquals(expectedException.getMessage(), "Negative numbers are not allowed");
    }

    @Test
    public void whenBuildNullShouldThrowException(){
        Exception expectedException = assertThrows(InvalidNaturalNumberException.class,
                () -> NaturalNumber.build(null));
        assertEquals(expectedException.getMessage(), "This <<null>> number is not allowed");
    }

    @Test
    public void whenBuildEmptyStringShouldThrowException(){
        Exception expectedException = assertThrows(InvalidNaturalNumberException.class,
                () -> NaturalNumber.build(""));
        assertEquals(expectedException.getMessage(), "This <<>> number is not allowed");
    }

    @Test
    public void whenBuildNonStringNumberShouldThrowException(){
        Exception expectedException = assertThrows(InvalidNaturalNumberException.class,
                () -> NaturalNumber.build("abc"));
        assertEquals(expectedException.getMessage(), "This <<abc>> number is not allowed");
    }
}
