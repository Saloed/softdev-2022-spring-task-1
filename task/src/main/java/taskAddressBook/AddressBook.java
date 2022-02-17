package taskAddressBook;

import java.util.*;

public class AddressBook {
    public static class Address {
        private final String street;
        private final int house;
        private final int apartment;

        @Override
        public String toString() {
            return (street + " " + house + " " + apartment);
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

        public Address(String street, int house, int apartment) {
            this.street = street;
            this.house = house;
            this.apartment = apartment;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;
        if (obj.getClass().equals(this.getClass())) {
            AddressBook other = (AddressBook) obj;
            return this.addresses.equals(other.addresses);
        } else return false;
    }

    public Map<String, Address> addresses;

    public AddressBook(LinkedHashMap<String, Address> ads) {
        this.addresses = ads;
    }

    public void add(String name, Address ad) {
        addresses.put(name, ad);
    }

    public void remove(String name) {
        addresses.remove(name);
    }

    public Set<String> names() {
        return this.addresses.keySet();
    }

    public Address findAddress(String name) {
        return addresses.get(name);
    }

    public List<String> findResidents(String street) {
        List<String> Residents = new ArrayList<>();
        for (String name : addresses.keySet()) {
            Address ad = addresses.get(name);
            if (Objects.equals(ad.street, street)) {
                Residents.add(name);
            }
        }
        return Residents;
    }

    public List<String> findResidents(String street, int house) {
        List<String> Residents = new ArrayList<>();
        for (String name : addresses.keySet()) {
            Address ad = addresses.get(name);
            if (Objects.equals(ad.street, street) && ad.house == house) {
                Residents.add(name);
            }
        }
        return Residents;
    }

}

