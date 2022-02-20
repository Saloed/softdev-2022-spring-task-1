package task1;

import java.util.Objects;

public class Edge {

    private Vertex start; // Направление от начальной вершины к конечной
    private Vertex end;
    private int weight;

    public Vertex getStart() { return this.start; }

    public Vertex getEnd() { return this.end; }

    public int getWeight() { return this.weight; }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Edge(Vertex start, Vertex end, int weight){
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return weight == edge.weight && Objects.equals(start, edge.start) && Objects.equals(end, edge.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end, weight);
    }

    @Override
    public String toString() {
        return "Edge{ start = " + start + ", end = " + end + ", weight = " + weight + '}';
    }
}
