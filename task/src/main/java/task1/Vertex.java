package task1;

import java.util.Objects;

public class Vertex {

    private String name;

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

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
        return "Vertex{ name= " + name + '}';
    }
}
