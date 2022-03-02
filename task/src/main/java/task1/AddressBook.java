package task1;

import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class AddressBook {

    public static class Address {
        private final String street;
        private final int house;
        private final int apartment;

        public Address(String street1, int house1, int apartment1) {
            this.street = street1;
            this.house = house1;
            this.apartment = apartment1;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) return true;
            if (obj == null) return false;
            if (obj.getClass().equals(this.getClass())) {
                Address other = (Address) obj;
                return Objects.equals(this.street, other.street) && this.house == other.house && this.apartment == other.apartment;
            } else return false;
        }

        @Override
        public String toString() {
            return (street + ", " + house + ", " + apartment);
        }
    }



    private final Map<String, Address> bookAddresses;

    public AddressBook(Map<String, Address> addresses) {
        this.bookAddresses = addresses;
    }
    public Map<String, Address> getBookAddresses() {
        return bookAddresses;
    }



    public void addPair(String lastName, Address adr) {
        bookAddresses.put(lastName, adr);
    }

    public void deleteAddress(String lastName) {
        bookAddresses.remove(lastName);
    }

    public Map<String, Address> changeAddress(String lastName, Address adr) {
        bookAddresses.put(lastName, adr);
        return bookAddresses;
    }

    public Address returnAddress(String lastName) {
        return bookAddresses.get(lastName);
    }

    public Set<String> getLastNamesByStreet(String str) {
        Set<String> lastNames = new HashSet<>();
        for (Map.Entry<String, Address> pair: bookAddresses.entrySet()) {
            if (pair.getValue().street.equals(str)) {
                lastNames.add(pair.getKey());
            }
        }
        return lastNames;
    }

    public Set<String> getLastNamesByHouse(String str, int ho) {
        Set<String> lastNames = new HashSet<>();
        for (Map.Entry<String, Address> pair: bookAddresses.entrySet()) {
            if (pair.getValue().house == ho && pair.getValue().street.equals(str)) {
                lastNames.add(pair.getKey());
            }
        }
        return lastNames;
    }
}