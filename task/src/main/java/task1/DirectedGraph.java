package task1;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.HashMap;
import java.util.HashSet;

public class DirectedGraph {

    private final AbstractMap<String, Vertex> vertices; // Вершины

    private final AbstractSet<Edge> edges; // Дуги

    public AbstractMap<String, Vertex> getVertices() { return vertices; }

    public AbstractSet<Edge> getEdges() { return edges; }

    public DirectedGraph() {
        this.vertices = new HashMap<>();
        this.edges = new HashSet<>();
    }

    public void addVertex(Vertex v){
        if(v != null) {
            vertices.put(v.getName(), v);
        }
    }

    public void addEdge(Edge e){
        if(e != null) {
            Vertex startVertex = vertices.get(e.getStart().getName());
            Vertex endVertex = vertices.get(e.getEnd().getName());
            if (startVertex != null && endVertex != null && e.getWeight() > 0) { //В условии задачи сказано вес целое положительное число
                edges.add(e);
                startVertex.outcomes.add(e);
                endVertex.incomes.add(e);
            }
        }
    }

    public void removeVertex(Vertex vertex){
        if( vertex != null && vertices.get(vertex.getName()) != null) {
            edges.removeIf(e -> e.getStart().equals(vertex) || e.getEnd().equals(vertex));
            vertices.remove(vertex.getName());
        }
    }

    public void removeEdge(Edge edge){
        if(edges.contains(edge)) {
            edge.getStart().outcomes.remove(edge);
            edge.getEnd().incomes.remove(edge);
            edges.remove(edge);
        }
    }

    public void changeName(Vertex vertex, String name){
        if(vertices.get(vertex.getName()) != null && !vertices.containsKey(name)) { // Проверка существования вершины и занято ли данное имя
            vertices.remove(vertex.getName());
            vertex.setName(name);
            vertices.put(name, vertex);
        }
    }

    public void changeWeight(Edge edge, int weight){
        if(edge != null && weight > 0) {
            edge.setWeight(weight);
        }
    }

    public AbstractSet<Edge> getOutcomes(String name){
        if(name != null) {
            return vertices.get(name).getOutcomes();
        }
        return null;
    }

    public AbstractSet<Edge> getIncomes(String name){
        if(name != null) {
            return vertices.get(name).getIncomes();
        }
        return null;
    }

    @Override
    public String toString() {
        return "DirectedGraph{vertices = " + vertices + ", edges = " + edges + '}';
    }
}
