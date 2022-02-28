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

    private Map<String, Map<Integer, Set<String>>> residentsByStreet;

    public AddressBook(Map<String, Address> ads) {
        this.addresses = new HashMap<>();
        this.residentsByStreet = new HashMap<>();
            for (Map.Entry<String, Address> entry : ads.entrySet()) {
                this.add(entry.getKey(), entry.getValue());
        }
    }

    public AddressBook() {
        this.addresses = new HashMap<>();
        this.residentsByStreet = new HashMap<>();
    }

    public void add(String name, Address ad) {
        addresses.put(name, ad);
        String street = ad.street;
        int house = ad.house;
        if (!residentsByStreet.containsKey(street)) {
            residentsByStreet.put(street, new HashMap<>());
        }
        if (!residentsByStreet.get(street).containsKey(house)) {
            residentsByStreet.get(street).put(house, new HashSet<>());
        }
        residentsByStreet.get(street).get(house).add(name);
    }

    public void remove(String name) {
        String street = addresses.get(name).street;
        int house = addresses.get(name).house;
        residentsByStreet.get(street).get(house).remove(name);
        addresses.remove(name);
    }

    public void changeAddress(String name, Address ad) {
        this.remove(name);
        this.add(name, ad);
    }

    public Set<String> names() {
        return this.addresses.keySet();
    }

    public Address findAddress(String name) {
        return addresses.get(name);
    }

    public Set<String> findResidents(String street) {
        Set<String> residents = new HashSet<>();
        for (Map.Entry<Integer, Set<String>> entry : residentsByStreet.get(street).entrySet()) {
            residents.addAll(entry.getValue());
        }
        return residents;
    }

    public Set<String> findResidents(String street, int house) {

        if (residentsByStreet.containsKey(street) && residentsByStreet.get(street).containsKey(house))
            return residentsByStreet.get(street).get(house);
        else return new HashSet<>();
    }
}


