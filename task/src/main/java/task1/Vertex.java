package task1;

import java.util.AbstractSet;
import java.util.HashSet;
import java.util.Objects;

public class Vertex {

    private String name;

    public HashSet<Edge> outcomes = new HashSet<>();

    public HashSet<Edge> incomes = new HashSet<>();

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public AbstractSet<Edge> getOutcomes() {
        return outcomes;
    }

    public AbstractSet<Edge> getIncomes() {
        return incomes;
    }

    public Vertex(String name){
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return Objects.equals(name, vertex.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Vertex{name = " + name + '}';
    }
}
