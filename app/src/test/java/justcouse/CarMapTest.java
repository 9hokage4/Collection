package justcouse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarMapTest {

    private CarMap map;

    @BeforeEach
    void setUp() throws Exception {
        map = new CarHashMap();
    }

    @Test
    public void whenPut100ElementsThenSizeBecome100(){
        for(int i = 0; i < 100; i++){
            CarOwner carOwner = new CarOwner(i, "Name" + i, "LastName" + i);
            Car car = new Car("Brand" + i, i);
            map.put(carOwner, car);
        }
        assertEquals(100, map.size());
    }

    @Test
    public void whenPut100ElementsWith10DifferentKeysThenSize10(){
        for (int i = 0; i < 100; i++){
            int index = i % 10;
            CarOwner carOwner = new CarOwner(index, "Name" + index, "LastName" + index);
            Car car = new Car("Brand" + index, index);
            map.put(carOwner, car);
        }

        assertEquals(10, map.size());
    }

    @Test
    public void removeReturnOnlyOnce(){
        for(int i = 0; i < 10; i++){
            CarOwner carOwner = new CarOwner(i, "Name" + i, "LastName" + i);
            Car car = new Car("Brand" + i, i);
            map.put(carOwner, car);
        }

        assertEquals(10, map.size());

        CarOwner carForDeleting = new CarOwner(5, "Name5", "LastName5");
        assertTrue(map.remove(carForDeleting));
        assertEquals(9, map.size());
        assertFalse(map.remove(carForDeleting));
    }

    @Test
    public void methodGetMustReturnRightValue(){
        for(int i = 0; i < 100; i++){
            CarOwner carOwner = new CarOwner(i, "Name" + i, "LastName" + i);
            Car car = new Car("Brand" + i, i);
            map.put(carOwner, car);
        }

        CarOwner key = new CarOwner(50, "Name50", "LastName50");
        Car value = map.get(key);
        String expectedCarBrand = "Brand50";
        assertEquals(expectedCarBrand, value.getBrand());
    }

}