package task1;

import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Objects;


public class PriceList<object> {
    private final HashMap<Integer, InfOfProducts> listOfPrices;
    private int lastId;

    public PriceList() {
        listOfPrices = new HashMap<>();
        lastId = 0;
    }

    public void addElement(String name, double price) {
        if (listOfPrices.containsKey(1 + lastId)) throw new IllegalArgumentException("Такой id уже имеется");
        InfOfProducts info = new InfOfProducts(name, price);
        listOfPrices.put(++lastId, info);
    }

    public void replaceName(int id, String newname) {
        if (!listOfPrices.containsKey(id)) throw new NoSuchElementException();
        listOfPrices.get(id).setName(newname);
    }

    public void replaceCost(int id, Double newcost) {
        if (!listOfPrices.containsKey(id)) throw new NoSuchElementException();
        listOfPrices.get(id).setCost(newcost);
    }

    public void deleteItem(int id) {
        if (!listOfPrices.containsKey(id)) throw new NoSuchElementException();
        listOfPrices.remove(id);
    }

    public InfOfProducts getElement(int id) {
        if (!listOfPrices.containsKey(id)) throw new NoSuchElementException();
        return listOfPrices.get(id);
    }

    public HashMap<Integer, InfOfProducts> getListOfPrices() {//геттер для мапы
        return listOfPrices;
    }

    public int getId(String name) {
        for (Integer key : listOfPrices.keySet())
        {
            if (Objects.equals(listOfPrices.get(key).getName(), name))
            {
                return key;
            }
        }

        throw new NoSuchElementException("Такого id нет!");
    }


    public double total(int id, int count) {
        if (!listOfPrices.containsKey(id)) throw new NoSuchElementException();
        return listOfPrices.get(id).getCost() * count;
    }
}
