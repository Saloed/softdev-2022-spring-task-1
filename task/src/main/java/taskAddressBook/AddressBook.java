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

    private Map<String, Address> addresses;

    private Map<String, List<String>> residentsByStreet;

    public AddressBook(Map<String, Address> ads) {
        this.addresses = ads;
        this.residentsByStreet = new HashMap<>();
        if (!addresses.isEmpty()) {
            for (String name : addresses.keySet()) {
                String street = addresses.get(name).street;
                if (!residentsByStreet.containsKey(street)) {
                    residentsByStreet.put(street, new ArrayList<>());
                }
                residentsByStreet.get(street).add(name);
            }
        }
    }

    public AddressBook() {
        this.addresses = new HashMap<>();
        this.residentsByStreet = new HashMap<>();
    }

    public void add(String name, Address ad) {
        addresses.put(name, ad);
        String street = ad.street;
        if (!residentsByStreet.containsKey(street)) {
            residentsByStreet.put(street, new ArrayList<>());
        }
        residentsByStreet.get(street).add(name);
    }

    public void remove(String name) {
        String street = addresses.get(name).street;
        residentsByStreet.get(street).remove(name);
        addresses.remove(name);
    }

    public void changeAddress(String name, Address ad) {
        String oldStreet = addresses.get(name).street;
        String newStreet = ad.street;
        residentsByStreet.get(oldStreet).remove(name);
        if (!residentsByStreet.containsKey(newStreet)) {
            residentsByStreet.put(newStreet, new ArrayList<>());
        }
        this.addresses.put(name, ad);
    }

    public Set<String> names() {
        return this.addresses.keySet();
    }

    public Address findAddress(String name) {
        return addresses.get(name);
    }

    public List<String> findResidents(String street) {

        if (residentsByStreet.containsKey(street)) return residentsByStreet.get(street);
        else return new ArrayList<>();
    }

    public List<String> findResidents(String street, int house) {

        if (residentsByStreet.containsKey(street)) {
            List<String> residents = new ArrayList<>();
            for (String name : residentsByStreet.get(street)) {
                if (addresses.get(name).house == house) {
                    residents.add(name);
                }
            }
            return residents;
        } else return new ArrayList<>();
    }
}


