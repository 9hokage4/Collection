import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarListTest {

    private CarList carList;

    @BeforeEach
    public void setUp() throws Exception {
        for (int i = 0; i < 100; i++) {
            carList.add(new Car("Brand" + i, "Name" + i));
        }
    }

    @Test
    public void whenAdded100ElementsThenSizeMustBe100() {
        assertEquals(100, carList.size());
    }

    @Test
    public void whenElementRemoveByIndexThenSizeMustBeDecreased() {
        assertTrue(carList.removeAt(5));
        assertEquals(99, carList.size());
    }
}
