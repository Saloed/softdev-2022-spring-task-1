package task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PriceList {//конструктор
    PriceList(String strproducts,String strprices){
        String [] strarray = strproducts.split("; ");
        products.addAll(Arrays.asList(strarray));//превращает массив в список
        String [] pricesarray = strprices.split("; ");
        for (String str: pricesarray){
            prices.add(Double.parseDouble(str));
        }
    }
    private final List<String> products = new ArrayList<>();
    private final List<Double> prices = new ArrayList<>();

    public void add(String name, Double price) {
        if (products.contains(name)) {
            prices.set(products.indexOf(name), price);
            return;
        }
        products.add(name);
        prices.add(price);
    }

    public void replacePriceById(int id, Double newprice) {
        if (id < 0 || id > prices.size()-1) return;
        prices.set(id, newprice);
    }

    public void replacePriceByName(String name, Double newprice) {
        if (!products.contains(name)) return;
        prices.set(products.indexOf(name), newprice);
    }

    public void deleteByName(String name) {
        if (!products.contains(name)) return;
        int id = products.indexOf(name);
        products.remove(id);
        prices.remove(id);

    }

    public void deleteById(int id) {
        if (id < 0 || id > prices.size() - 1) return;
        products.remove(id);
        prices.remove(id);

    }

    public void replacePriceById(int id, String newname) {
        if (id < 0 || id > products.size()) return;
        products.set(id, newname);
    }

    public void replaceNameByName(String name, String newname) {
        if (!products.contains(name)) return;
        products.set(products.indexOf(name), newname);
    }

    public Double purchaseAmount(int id, int value) {
        return prices.get(id) * value;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < products.size(); i++){
            sb.append(products.get(i));
            sb.append(" ");
            sb.append(prices.get(i));
            sb.append("; ");
        }
        sb.deleteCharAt(sb.length()-1);
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}
