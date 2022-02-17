package task1;

import java.util.*;

public class AddressBook {

    private final Map<String, String> addresses;

    public AddressBook(HashMap<String, String> book) {
        this.addresses = book;
    }

    public Map addPair(Map<String, String> book) {
        addresses.putAll(book);
        return addresses;
    }

    public Map deleteAddress(String surname) {
        addresses.remove(surname);
        return addresses;
    }

    public Map changeAddress (String surname, String newAddress) {
        addresses.put(surname, newAddress);
        return addresses;
    }

    public String getAddress(String surname) {
        return addresses.get(surname);
    }

    public Set getInhabitantByStreet(String street) {
        Set<String> result = new HashSet();
        for (Map.Entry<String, String> i: addresses.entrySet()) {
            String address = i.getValue();
            if (getStreet(address).equals(street)) {
                result.add(i.getKey());
            }
        }
        return result;
    }

    public Set getInhabitantByHouse (String house) {
        Set<String> result = new HashSet();
        for (Map.Entry<String, String> i: addresses.entrySet()) {
            String address = i.getValue();
            if (getHouse(address).equals(house)) {
                result.add(i.getKey());
            }
        }
        return result;
    }

    //Вспомогательные методы для получения улицы или дома из адреса
    public String getStreet(String address) {
        //улица Харченко, 34, кв.5
        String[] parts = address.split(", ");
        String street = parts[0].split(" ")[1];
        return street;
    }

    public String getHouse(String address) {
        //улица Харченко, 34, кв.5
        String[] parts = address.split(", ");
        StringJoiner joiner = new StringJoiner(", ");
        joiner.add(parts[0].replace("улица ", ""));
        joiner.add(parts[1]);
        String house = joiner.toString();
        return house;
    }
}