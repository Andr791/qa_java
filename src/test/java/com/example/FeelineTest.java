package com.example;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

 @ExtendWith(MockitoExtension.class)
public class FeelineTest { // вынес параметризацию в отдельный класс, т.к. это прописано в задании.

    @Mock
    Feline feline;

    @ParameterizedTest
    @CsvSource({
            "-1, -1",
            "0, 0",
            "1, 1",
            "2, 2"
    })
    void testGetKittensReturnsCustomCount(int count, int expectedResult){
        Feline feline1 = new Feline();
        int actual = feline1.getKittens(count);
        assertEquals(expectedResult, actual);
    }


}
