package com.teladoc.teladocJavaTest;

import com.teladoc.teladocJavaTest.exceptions.InvalidNaturalNumberException;
import com.teladoc.teladocJavaTest.exceptions.InvalidNegativeNumberException;
import com.teladoc.teladocJavaTest.models.NaturalAddition;
import com.teladoc.teladocJavaTest.models.NaturalNumber;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NaturalAdditionTest {

    @Test
    public void whenAddTwoNumbersShouldReturnNewNaturalNumberWithTheSum(){

        NaturalAddition naturalAddition = new NaturalAddition();

        assertEquals(naturalAddition.addNumbers("123456789012345678901", "12345678"),
                NaturalNumber.build("123456789012358024579").toString());
        assertEquals(naturalAddition.addNumbers("123", "11"),
                NaturalNumber.build("134").toString());
    }

    @Test
    public void whenAddAListOfNumbersShouldReturnNewNaturalNumberWithTheSum(){

        NaturalAddition naturalAddition = new NaturalAddition();
        NaturalNumber result = naturalAddition.execute(List.of(NaturalNumber.build("123456789012345678901"),
                NaturalNumber.build("12345678")));
        assertEquals(result, NaturalNumber.build("123456789012358024579"));
    }

}
