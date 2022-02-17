package task1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class AddressBookTest {

    public HashMap<String, String> getBook() {
        HashMap<String, String> b1 = new HashMap<>();
        b1.put("Сидоров", "улица Харченко, 16, кв.23");
        b1.put("Петров", "улица Харченко, 14, кв.68");
        return b1;
    }

    @Test
    public void getAddress() {
        AddressBook b1 = new AddressBook(getBook());
        String testAdr = "улица Харченко, 16, кв.23";
        assertEquals(testAdr, b1.getAddress("Сидоров"));
    }

    @Test
    public void addPair() {
        AddressBook b1 = new AddressBook(getBook());
        HashMap<String, String> b2 = new HashMap<>();
        b2.put("Сидоров", "улица Харченко, 16, кв.23");
        b2.put("Петров", "улица Харченко, 14, кв.68");
        b2.put("Алексеев", "улица Матросов, 34, кв.5");
        HashMap<String, String> pairToAdd = new HashMap<>();
        pairToAdd.put("Алексеев", "улица Матросов, 34, кв.5");
        assertEquals(b2, b1.addPair(pairToAdd));
    }

    @Test
    public void deleteAddress() {
        AddressBook b1 = new AddressBook(getBook());
        HashMap<String, String> b2 = new HashMap<>();
        b2.put("Сидоров", "улица Харченко, 16, кв.23");
        assertEquals(b2, b1.deleteAddress("Петров"));
    }

    @Test
    public void changeAddress() {
        AddressBook b1 = new AddressBook(getBook());
        HashMap<String, String> b2 = new HashMap<>();
        b2.put("Сидоров", "улица Харченко, 16, кв.23");
        b2.put("Петров", "улица Звездная, 18, кв.15");
        assertEquals(b2, b1.changeAddress("Петров", "улица Звездная, 18, кв.15"));
    }

    @Test
    public void getInhabitantByStreet() {
        AddressBook b1 = new AddressBook(getBook());
        Set<String> inhabitantInStreet = new HashSet<>();
        inhabitantInStreet.add("Сидоров");
        inhabitantInStreet.add("Петров");
        assertEquals(inhabitantInStreet, b1.getInhabitantByStreet("Харченко"));
    }

    @Test
    public void getInhabitantByHouse() {
        AddressBook b1 = new AddressBook(getBook());
        Set<String> inhabitantInHouse = new HashSet<>();
        inhabitantInHouse.add("Сидоров");
        assertEquals(inhabitantInHouse, b1.getInhabitantByHouse("Харченко, 16"));
    }

    //Тесты для проверки работоспособности вспомогательных методов
    @Test
    public void getStreet() {
        String test = "Харченко";
        AddressBook b1 = new AddressBook(getBook());
        assertEquals(test, b1.getStreet("улица Харченко, 16, кв.23"));
    }

    @Test
    public void getHouse() {
        String test = "Харченко, 16";
        AddressBook b1 = new AddressBook(getBook());
        assertEquals(test, b1.getHouse("улица Харченко, 16, кв.23"));
    }
}