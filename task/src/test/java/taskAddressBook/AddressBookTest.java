package taskAddressBook;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import taskAddressBook.AddressBook.Address;

public class AddressBookTest {
    @Test
    public void add() {
        AddressBook book1 = new AddressBook(new LinkedHashMap<>());
        book1.add("Алексеев", new Address("Ветеранов", 73, 82));
        LinkedHashMap<String, Address> addresses = new LinkedHashMap<>();
        addresses.put("Алексеев", new Address("Ветеранов", 73, 82));
        assertEquals(book1, new AddressBook(addresses));
    }

    @Test
    public void remove() {
        LinkedHashMap<String, Address> addresses = new LinkedHashMap<>();
        addresses.put("Алексеев", new Address("Ветеранов", 73, 82));
        AddressBook book1 = new AddressBook(addresses);
        book1.remove("Алексеев");
        LinkedHashMap<String, Address> addresses1 = new LinkedHashMap<>();
        assertEquals(book1, new AddressBook(addresses1));
    }

    @Test
    public void names() {
        LinkedHashMap<String, Address> addresses = new LinkedHashMap<>();
        addresses.put("Алексеев", new Address("Ветеранов", 73, 82));
        AddressBook book1 = new AddressBook(addresses);
        Set<String> nm = new HashSet<>();
        nm.add("Алексеев");
        assertEquals(book1.names(), nm);
    }

    @Test
    public void findAddress() {
        LinkedHashMap<String, Address> addresses = new LinkedHashMap<>();
        addresses.put("Алексеев", new Address("Ветеранов", 73, 82));
        AddressBook book1 = new AddressBook(addresses);
        assertEquals(book1.findAddress("Алексеев"), new Address("Ветеранов", 73, 82));
    }


    @Test
    public void findResidents() {
        AddressBook book1 = new AddressBook(new LinkedHashMap<>());
        book1.add("Алексеев", new Address("Ветеранов", 73, 82));
        book1.add("Беляев", new Address("Ветеранов", 73, 85));
        book1.add("Страхов", new Address("Добровольцев", 73, 82));
        book1.add("Рубцов", new Address("Московская", 102, 90));
        book1.add("Петрушин", new Address("Ветеранов", 81, 111));
        List<String> res1 = new ArrayList<>();
        res1.add("Алексеев");
        res1.add("Беляев");
        res1.add("Петрушин");
        assertEquals(res1, book1.findResidents("Ветеранов"));
        List<String> res2 = new ArrayList<>();
        res2.add("Алексеев");
        res2.add("Беляев");
        assertEquals(res2, book1.findResidents("Ветеранов", 73));
    }
}
