package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.spy;

 @ExtendWith(MockitoExtension.class)
 public class FelineTests {

    @Test
    void eatMeat() throws Exception {
        Feline feline = new Feline();
        Feline spyFeline = spy(feline);
        spyFeline.eatMeat();
        Mockito.verify(spyFeline).getFood("Хищник");
    }


   @Test
    void getFamily() {
        Feline feline1 = new Feline();
        assertEquals("Кошачьи", feline1.getFamily());
    }


    @Test
    public void testGetFoodForHerbivore() throws Exception {
        Feline animalFood = new Feline();
        List<String> foodList = animalFood.getFood("Травоядное");
        assertEquals(List.of("Трава", "Различные растения"), foodList);
    }

    @Test
    public void testGetFoodForPredator() throws Exception {
        Feline animalFood = new Feline();
        List<String> foodList = animalFood.getFood("Хищник");
        assertEquals(List.of("Животные", "Птицы", "Рыба"), foodList);
    }

    @Test
    public void testUnknownAnimalKind() throws Exception {
        Feline animalFood = new Feline();
        Throwable exception = assertThrows(
                Exception.class,
                () -> animalFood.getFood("Неизвестный вид животного")
        );
        assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", exception.getMessage());
    }

    @Test
    void testGetKittensReturnsDefaultCount() {
        Feline feline = new Feline();
        Feline spyFeline = spy(feline);
        spyFeline.getKittens();
        Mockito.verify(spyFeline, Mockito.times(1)).getKittens(1);
    }
}