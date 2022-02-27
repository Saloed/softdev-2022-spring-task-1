package task1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import task1.AddressBook.Address;

public class AddressBookTest {

    public HashMap<String, Address> getBook() {
        HashMap<String, Address> b1 = new HashMap<>();
        b1.put("Сидоров", new Address("Харченко", 16, 23));
        b1.put("Петров", new Address("Харченко", 14, 68));
        return b1;
    }

    @Test
    public void getAddress() {
        AddressBook b1 = new AddressBook();
        b1.setMap(getBook());
        Address testAdr = new Address("Харченко", 16, 23);
        assertEquals(testAdr, b1.getAddress("Сидоров"));
    }

    @Test
    public void addPair() {
        AddressBook b1 = new AddressBook();
        b1.setMap(getBook());
        AddressBook check = new AddressBook();
        HashMap<String, Address> b2 = new HashMap<>();
        b2.put("Сидоров", new Address("Харченко", 16, 23));
        b2.put("Петров", new Address("Харченко", 14, 68));
        b2.put("Алексеев", new Address("Матросов", 34, 5));
        check.setMap(b2);
        b1.addPair("Алексеев", new Address("Матросов", 34, 5));
        assertEquals(check, b1);
    }

    @Test
    public void deleteAddress() {
        AddressBook b1 = new AddressBook();
        b1.setMap(getBook());
        AddressBook check = new AddressBook();
        HashMap<String, Address> b2 = new HashMap<>();
        b2.put("Сидоров", new Address("Харченко", 16, 23));
        b1.deleteAddress("Петров");
        check.setMap(b2);
        assertEquals(check, b1);
    }

    @Test
    public void changeAddress() {
        AddressBook b1 = new AddressBook();
        b1.setMap(getBook());
        HashMap<String, Address> b2 = new HashMap<>();
        b2.put("Сидоров", new Address("Харченко", 16, 23));
        b2.put("Петров", new Address("Звездная", 18, 15));
        assertEquals(b2, b1.changeAddress("Петров", new Address("Звездная", 18, 15)));
    }

    @Test
    public void getInhabitantByStreet() {
        AddressBook b2 = new AddressBook();
        b2.setMap(getBook());
        Set<String> inhabitantInStreet = new HashSet<>();
        inhabitantInStreet.add("Сидоров");
        inhabitantInStreet.add("Петров");
        assertEquals(inhabitantInStreet, b2.getInhabitantByStreet("Харченко"));
    }

    @Test
    public void getInhabitantByHouse() {
        AddressBook b2 = new AddressBook();
        b2.setMap(getBook());
        Set<String> inhabitantInHouse = new HashSet<>();
        inhabitantInHouse.add("Сидоров");
        assertEquals(inhabitantInHouse, b2.getInhabitantByHouse("Харченко", 16));
    }

    @Test
    public void complexTest() {
        AddressBook b2 = new AddressBook();
        b2.setMap(getBook());
        b2.addPair("Ершов", new Address("Ленина", 35, 2));
        b2.deleteAddress("Петров");
        b2.changeAddress("Ершов", new Address("Харченко", 16, 47));
        Set<String> res = new HashSet<>();
        res.add("Ершов");
        res.add("Сидоров");
        assertEquals(b2.getInhabitantByStreet("Харченко"), res);
    }
}