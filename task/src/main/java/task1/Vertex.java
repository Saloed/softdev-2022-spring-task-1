package task1;

import java.util.*;

public class Vertex {

    private String name;

    public Set<Edge> outcomes;

    public Set<Edge> incomes;

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Set<Edge> getOutcomes() {
        return outcomes;
    }

    public Set<Edge> getIncomes() {
        return incomes;
    }

    public Vertex(String name){
        this.name = name;
        outcomes = null;
        incomes = null;
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
