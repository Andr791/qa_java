package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

 @ExtendWith(MockitoExtension.class)
class LionTests {

    @Mock
    Feline feline;

    @Test
    void getKittens() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        lion.getKittens();
        Mockito.verify(feline).getKittens();
    }

    @Test
    void getFood() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        lion.getFood();
        Mockito.verify(feline).getFood("Хищник");
    }


    @Test
    public void testMaleLionHasMane() throws Exception {
        Lion maleLion = new Lion(feline,"Самец");
        assertTrue(maleLion.doesHaveMane());
    }

    @Test
    public void testFemaleLionDoesNotHaveMane() throws Exception {
        Lion femaleLion = new Lion(feline,"Самка");
        assertFalse(femaleLion.doesHaveMane());
    }

    @Test
    public void testUnknownSexThrowsException() throws Exception {
        Throwable exception = assertThrows(Exception.class, () -> new Lion(feline,"Некорректное значение пола"));
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }

}

