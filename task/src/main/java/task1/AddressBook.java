package task1;

import java.util.*;

public class AddressBook {

    public static class Address {
        private final String street;
        private final int house;
        private final int flat;

        public Address(String str, int h, int fl) {
            this.street = str;
            this.house = h;
            this.flat = fl;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) return true;
            if (obj == null) return false;
            if (obj.getClass().equals(this.getClass())) {
                Address other = (Address) obj;
                return Objects.equals(this.street, other.street) && this.house == other.house && this.flat == other.flat;
            } else return false;
        }

        @Override
        public String toString() {
            return (street + ", " + house + ", " + flat);
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

    private final Map<String, Address> addresses;
    private final Map<String, Map<Integer, Set<String>>> inhabitants = new HashMap<>();

    public AddressBook() {
        this.addresses = new HashMap<String, Address>();
    }

    public AddressBook(Map<String, Address> adr) {
        this.addresses = adr;
        if (!addresses.isEmpty())
            for (Map.Entry<String, Address> i: addresses.entrySet()) {
                String surname = i.getKey();
                Address address = i.getValue();
                setInhabitants(surname, address);
            }
    }

    private void setInhabitants(String sur, Address adr) {
        if (!inhabitants.containsKey(adr.street)) {
            Set<String> inh = new HashSet<>();
            inh.add(sur);
            Map<Integer, Set<String>> matches = new HashMap<>();
            matches.put(adr.house, inh);
            inhabitants.put(adr.street, matches);
        } if (inhabitants.get(adr.street).containsKey(adr.house)) {
            Set<String> inh = inhabitants.get(adr.street).get(adr.house);
            inh.add(sur);
            inhabitants.get(adr.street).get(adr.house).addAll(inh);
        } else {
            Set<String> inh = new HashSet<>();
            inh.add(sur);
            inhabitants.get(adr.street).put(adr.house, inh);
        }
    }

    public void addPair(String surname, Address adr) {
        addresses.put(surname, adr);
        setInhabitants(surname, adr);
    }

    public Map<String, Address> deleteAddress(String surname) {
        if (!addresses.containsKey(surname)) return addresses;
        String street = addresses.get(surname).street;
        int house = addresses.get(surname).house;
        addresses.remove(surname);
        inhabitants.get(street).get(house).remove(surname);
        if (!inhabitants.get(street).get(house).isEmpty()) return addresses;
        inhabitants.get(street).remove(house);
        if (!inhabitants.get(street).isEmpty()) return addresses;
        inhabitants.remove(street);
        return addresses;
    }

    public Map<String, Address> changeAddress (String surname, Address adr) {
        if (!addresses.containsKey(surname)) return addresses;
        String oldString = addresses.get(surname).street;
        addresses.put(surname, adr);
        inhabitants.remove(oldString);
        setInhabitants(surname, adr);
        return addresses;
    }

    public Address getAddress(String surname) {
        return addresses.get(surname);
    }

    public Set<String> getInhabitantByStreet(String street) {
        Set<String> result = new HashSet();
        if (inhabitants.containsKey(street)) {
            for (Map.Entry<Integer, Set<String>> i : inhabitants.get(street).entrySet()) {
                result.addAll(i.getValue());
            }
        }
        return result;
    }

    public Set<String> getInhabitantByHouse (String street, int house) {
        Set<String> result = new HashSet();
        if (inhabitants.containsKey(street)) {
            result.addAll(inhabitants.get(street).get(house));
        }
        return result;
    }
}