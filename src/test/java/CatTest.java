import com.example.Cat;
import com.example.Feline;
import com.example.Predator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class CatTest {

    private Feline felineMock; // мок Feline
    private Cat cat;

    @BeforeEach
    public void setUp() {
        // Создаем мок Feline
        felineMock = Mockito.mock(Feline.class);
        // Передаем мок в конструктор Cat
        cat = new Cat(felineMock);
    }

    @Test
    public void testGetSound_ReturnsМяу() {
        // Проверка, что getSound() возвращает "Мяу"
        String sound = cat.getSound();
        assertEquals("Мяу", sound);
    }

    @Test
    public void testGetFood_ReturnsEatenMeat() throws Exception {
        // Настраиваем мок на возвращение списка
        List<String> expectedFood = Arrays.asList("Мясо", "Рыба");
        Mockito.when(felineMock.eatMeat()).thenReturn(expectedFood);

        // Вызываем метод
        List<String> actualFood = cat.getFood();

        // Проверяем результат
        assertEquals(expectedFood, actualFood);
        // Проверяем, что мок был вызван один раз
        Mockito.verify(felineMock).eatMeat();
    }

    @Test
    public void testGetFood_ThrowsException() throws Exception {
        // Настраиваем мок на выбрасывание исключения
        Mockito.when(felineMock.eatMeat()).thenThrow(new Exception("Ошибка"));

        // Проверка, что исключение корректно пробрасывается
        Exception exception = assertThrows(Exception.class, () -> {
            cat.getFood();
        });
        assertEquals("Ошибка", exception.getMessage());
    }
}
