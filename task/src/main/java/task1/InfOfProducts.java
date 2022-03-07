package task1;

import java.util.HashMap;

public class InfOfProducts {
    private String name;
    private Double cost;

    public InfOfProducts(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }
    public String getName() {
        return name;
    }
    public Double getCost() {
        return cost;
    }
    public void setName(String name) {this.name = name;}
    public void setCost(double cost) {
        if (cost >= 0.0) {
            this.cost = cost;
        } else {
            this.cost = 0.0;
            System.out.print("Цена не может быть меньше 0");
        }
    }
}
