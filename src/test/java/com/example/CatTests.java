package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

 @ExtendWith(MockitoExtension.class)
class CatTests {

    @Mock
    Feline feline;

   @Test
    void testGetSoundReturnsMeow() {
        Cat cat1 = new Cat(new Feline());
        assertEquals("Мяу", cat1.getSound());
    }

  @Test
    void getFood() throws Exception {
        Cat cat = new Cat(feline);
        cat.getFood();
        Mockito.verify(feline).eatMeat();

    }
}