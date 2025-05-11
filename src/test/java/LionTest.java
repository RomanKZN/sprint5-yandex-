
import com.example.Feline;
import com.example.Lion;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.util.List;

public class LionTest {

    @Test
    public void testGetKittens_returnsCorrectNumber() throws Exception {
        // Создаем мок для Feline
        Feline mockFeline = mock(Feline.class);
        // Настраиваем мок на возвращение количества котят
        when(mockFeline.getKittens()).thenReturn(3);

        // Создаем объект Lion с полом "Самец" и мок объектом Feline
        Lion lion = new Lion("Самец", mockFeline);

        // Проверяем, что метод возвращает ожидаемое значение
        assertEquals(3, lion.getKittens());
    }

    @ParameterizedTest
    @CsvSource({
            "Самец, true",
            "Самка, false"
    })
    public void testDoesHaveMane_returnsCorrectly(String sex, boolean expectedHasMane) throws Exception {
        // Мокаем Feline
        Feline mockFeline = mock(Feline.class);
        Lion lion = new Lion(sex, mockFeline);
        assertEquals(expectedHasMane, lion.doesHaveMane());
    }


    @Test
    public void testGetFood_returnsFelineFood() throws Exception {
        // Мокаем Feline и его метод getFood
        Feline mockFeline = mock(Feline.class);
        List<String> expectedFood = List.of("Мясо", "Рыба");
        when(mockFeline.getFood("Хищник")).thenReturn(expectedFood);

        Lion lion = new Lion("Самец", mockFeline);
        List<String> actualFood = lion.getFood();

        assertEquals(expectedFood, actualFood);
        verify(mockFeline).getFood("Хищник");
    }

    @Test
    public void testConstructor_throwsExceptionForInvalidSex() {
        Feline mockFeline = mock(Feline.class);
        assertThrows(Exception.class, () -> {
            new Lion("Другой", mockFeline);
        });
    }
}