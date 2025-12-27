import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarListTest {

    private CarList carList;

    @BeforeEach
    public void setUp() throws Exception {
        // init
    }

    @Test
    public void whenAdded100ElementsThenSizeMustBe100() {
        for (int i = 0; i < 100; i++) {
            carList.add(new Car("Brand" + i, "Name" + i));
        }

        assertEquals(100, carList.size());
    }
}
