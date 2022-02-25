package task1;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class DirectedGraph {

    private final Map<String, Vertex> vertices; // Вершины

    private final Set<Edge> edges; // Дуги

    public Map<String, Vertex> getVertices() { return vertices; }

    public Set<Edge> getEdges() { return edges; }

    public DirectedGraph() {
        vertices = new HashMap<>();
        edges = new HashSet<>();
    }

    public void addVertex(@NotNull Vertex v){
        vertices.put(v.getName(), v);
    }

    public void addEdge(@NotNull Edge e) {
        Vertex startVertex = vertices.get(e.getStart().getName());
        Vertex endVertex = vertices.get(e.getEnd().getName());
        if(startVertex == null){
            throw new NullPointerException("Вершина, с которой начинается дуга, не содержится в графе.");
        }
        if(endVertex == null){
            throw new NullPointerException("Вершина, которой заканчивается дуга, не содержится в графе.");
        }
        if (e.getWeight() > 0) { //В условии задачи сказано вес целое положительное число
            edges.add(e);
            startVertex.outcomes.add(e);
            endVertex.incomes.add(e);
        }else{
            throw new IllegalArgumentException("Вес не может быть отрицательный.");
        }
    }

    public void removeVertex(@NotNull Vertex vertex){
        if(vertices.get(vertex.getName()) != null) {
            edges.removeAll(vertex.getIncomes());
            edges.removeAll(vertex.getOutcomes());
            vertices.remove(vertex.getName());
        }  else {
            throw new NullPointerException("Данная вершина в графе не содержится.");
        }
    }

    public void removeEdge(@NotNull Edge edge){
        if(edges.contains(edge)) {
            edge.getStart().outcomes.remove(edge);
            edge.getEnd().incomes.remove(edge);
            edges.remove(edge);
        } else {
            throw new NullPointerException("Данная дуга в графе не содержится.");
        }
    }

    public void changeName(@NotNull Vertex vertex,@NotNull String name){
        if(vertices.get(vertex.getName()) != null && !vertices.containsKey(name)) { // Проверка существования вершины и занято ли данное имя
            vertices.remove(vertex.getName());
            vertex.setName(name);
            vertices.put(name, vertex);
        } else {
            throw new NullPointerException("Не удалось изменить имя вершины.");
        }
    }

    public void changeWeight(@NotNull Edge edge, int weight){
        if(weight > 0) {
            edge.setWeight(weight);
        } else {
            throw new IllegalArgumentException("Вес не может быть отрицательный.");
        }

    }

    public Set<Edge> getOutcomes(@NotNull String name){
        return vertices.get(name).getOutcomes();
    }

    public Set<Edge> getIncomes(@NotNull String name){
        return vertices.get(name).getIncomes();
    }

    @Override
    public String toString() {
        return "DirectedGraph{vertices = " + vertices + ", edges = " + edges + '}';
    }
}
