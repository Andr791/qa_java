package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class FeelineTest { // вынес параметризацию в отдельный класс, т.к. это прописано в задании.



    @ParameterizedTest
    @CsvSource({
            "-1, -1",
            "0, 0",
            "1, 1",
            "2, 2"
    })
    void testGetKittensReturnsCustomCount(int count, int expectedResult){
        Feline feline = new Feline();
        int actual = feline.getKittens(count);
        assertEquals(expectedResult, actual);
    }


}
