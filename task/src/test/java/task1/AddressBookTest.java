package task1;

import org.junit.jupiter.api.Test;
import task1.AddressBook.Address;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.assertEquals;



public class AddressBookTest {

    @Test
    public void returnAddress() {
        Map<String, Address> bookAddresses = new HashMap<>();
        bookAddresses.put("Смирнов", new Address("Мира", 7, 17));
        AddressBook book1 = new AddressBook(bookAddresses);
        assertEquals(book1.returnAddress("Смирнов"), new Address("Мира", 7, 17));
    }

    @Test
    public void addPair() {
        Map<String, Address> bookAddresses = new HashMap<>();
        bookAddresses.put("Смирнов", new Address("Мира", 7, 17));
        AddressBook book2 = new AddressBook(bookAddresses);
        book2.addPair("Тихомиров", new Address("Смоленка", 8, 18));
        Map<String, Address> bookAddresses1 = new HashMap<>();
        bookAddresses1.put("Смирнов", new Address("Мира", 7, 17));
        bookAddresses1.put("Тихомиров", new Address("Смоленка", 8, 18));
        assertEquals(book2.getBookAddresses(), bookAddresses1);
    }

    @Test
    public void deleteAddress() {
        Map<String, Address> bookAddresses = new HashMap<>();
        bookAddresses.put("Смирнов", new Address("Мира", 7, 17));
        bookAddresses.put("Тихомиров", new Address("Смоленка", 8, 18));
        AddressBook book = new AddressBook(bookAddresses);
        book.deleteAddress("Смирнов");
        Map<String, Address> bookAddresses1 = new HashMap<>();
        bookAddresses1.put("Тихомиров", new Address("Смоленка", 8, 18));
        assertEquals(book.getBookAddresses(), bookAddresses1);
    }

    @Test
    public void changeAddress() {
        Map<String, Address> bookAddresses = new HashMap<>();
        bookAddresses.put("Смирнов", new Address("Мира", 7, 17));
        AddressBook book = new AddressBook(bookAddresses);
        Map<String, Address> bookAddresses1 = new HashMap<>();
        bookAddresses1.put("Смирнов", new Address("Смоленка", 8, 18));
        assertEquals(book.changeAddress("Смирнов", new Address("Смоленка", 8, 18)), bookAddresses1);
    }

    @Test
    public void getLastNamesByStreet() {
        Map<String, Address> bookAddresses = new HashMap<>();
        bookAddresses.put("Смирнов", new Address("Мира", 7, 17));
        bookAddresses.put("Спиридонов", new Address("Мира", 22, 29));
        bookAddresses.put("Тихомиров", new Address("Смоленка", 8, 18));
        AddressBook book = new AddressBook(bookAddresses);

        Set<String> bookAddresses1 = new HashSet<>();
        bookAddresses1.add("Смирнов");
        bookAddresses1.add("Спиридонов");
        assertEquals(book.getLastNamesByStreet("Мира"), bookAddresses1);
    }

    @Test
    public void getLastNamesByHouse() {
        Map<String, Address> bookAddresses = new HashMap<>();
        bookAddresses.put("Смирнов", new Address("Мира", 22, 17));
        bookAddresses.put("Спиридонов", new Address("Мира", 22, 29));
        bookAddresses.put("Тихомиров", new Address("Смоленка", 8, 18));
        AddressBook book = new AddressBook(bookAddresses);

        Set<String> bookAddresses1 = new HashSet<>();
        bookAddresses1.add("Смирнов");
        bookAddresses1.add("Спиридонов");
        assertEquals(book.getLastNamesByHouse("Мира", 22), bookAddresses1);
    }

}











