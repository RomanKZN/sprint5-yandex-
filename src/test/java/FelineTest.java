import com.example.Feline;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class FelineTest {

    @Test
    void testEatMeatReturnsFoodList() throws Exception {
        // Создаем объект Feline
        Feline feline = new Feline();

        // Вызываем метод и получаем список еды
        List<String> food = feline.eatMeat();

        // Проверяем, что список не null
        assertNotNull(food, "Список еды не должен быть null");
        // Проверяем, что список содержит хотя бы один ожидаемый элемент
        assertTrue(food.contains("Животные") || food.contains("Птицы") || food.contains("Рыба"),
                "Список еды должен содержать ожидаемые элементы");
    }

    @Test
    void testGetFamilyReturnsCorrectFamily() {
        // Создаем объект Feline
        Feline feline = new Feline();

        // Получаем название семейства
        String family = feline.getFamily();

        // Проверяем, что возвращается правильное название семейства
        assertEquals("Кошачьи", family);
    }

    @Test
    void testGetKittensDefaultReturnsOne() {
        // Создаем объект Feline
        Feline feline = new Feline();

        // Вызываем метод без аргументов
        int kittensCount = feline.getKittens();

        // Проверяем, что по умолчанию возвращается 1
        assertEquals(1, kittensCount);
    }

    @Test
    void testGetKittensWithArgumentReturnsArgument() {
        // Создаем объект Feline
        Feline feline = new Feline();

        // Вызываем метод с указанием количества котят
        int kittensCount = feline.getKittens(5);

        // Проверяем, что возвращается переданное количество
        assertEquals(5, kittensCount);
    }
}
