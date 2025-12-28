import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import justcouse.Car;
import justcouse.CarArrayList;
import justcouse.CarList;

public class CarListTest {

    private CarList carList;

    @BeforeEach
    public void setUp() throws Exception {
        carList = new CarArrayList();
        for (int i = 0; i < 100; i++) {
            carList.add(new Car("Brand" + i, i));
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

    @Test
    public void whenElementRemoveThenSizeMustBeDecreased() {
        Car car = new Car("BMW", 15);
        carList.add(car);

        assertTrue(carList.remove(car));
        assertEquals(100, carList.size());
    }

    @Test
    public void whenListClearedThenSizeMustBe0() {
        carList.clear();
        assertEquals(0, carList.size());
    }

    @Test()
    public void whenIndexOutOfBoundsThenThrowExceprion() {
        assertThrows(IndexOutOfBoundsException.class, () -> carList.get(100));
    }

    @Test
    public void methodGetReturnedValue() {
        Car car = carList.get(0);
        assertEquals("Brand0", car.getBrand());
    }

    @Test
    public void insertIntoMiddle() {
        Car car = new Car("Audi", 1);
        carList.add(car, 50);
        Car carFromList = carList.get(50);
        assertEquals("Audi", carFromList.getBrand());
    }

    @Test
    public void insertIntoFirstPosition() {
        Car car = new Car("Audi", 1);
        carList.add(car, 0);
        Car carFromList = carList.get(0);
        assertEquals("Audi", carFromList.getBrand());
    }

    @Test
    public void insertIntoLastPosition() {
        Car car = new Car("Audi", 1);
        carList.add(car, 100);
        Car carFromList = carList.get(100);
        assertEquals("Audi", carFromList.getBrand());
    }

}
