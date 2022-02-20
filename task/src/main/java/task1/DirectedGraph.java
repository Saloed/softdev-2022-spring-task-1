package task1;

import java.util.HashMap;
import java.util.HashSet;

public class DirectedGraph {

    private HashMap<String, Vertex> vertices; // Вершины

    private HashSet<Edge> edges; // Дуги

    public HashMap<String, Vertex> getVertices() { return vertices; }

    public HashSet<Edge> getEdges() { return edges; }

    public DirectedGraph(HashMap<String, Vertex> vertices, HashSet<Edge> edges) {
        this.vertices = vertices;
        this.edges = edges;
    }

    public void addVertex(String name){
        if(name != null) {
            vertices.put(name, new Vertex(name));
        }
    }

    public void addEdge(Vertex start, Vertex end,int weight){
        if(vertices.containsValue(start) && vertices.containsValue(end) && weight > 0) {
            edges.add(new Edge(start, end, weight));
        }
    }

    public void removeVertex(Vertex vertex){
        if(vertices.containsValue(vertex)) {
            for(Edge e: edges){
                if(e.getStart().equals(vertex)) edges.remove(e); // Удалить дугу, которая начинается с этой вершины
                else if(e.getEnd().equals(vertex)) edges.remove(e); // Удалить дугу, которая заканчивается этой вершиной
            }
            vertices.remove(vertex);
        }
    }

    public void removeEdge(Edge edge){
        if(edges.contains(edge)) {
            edges.remove(edge);
        }
    }

    public void changeName(Vertex vertex, String name){
        if(vertices.containsValue(vertex) && !vertices.containsKey(name)) { // Проверка существования вершины и занято ли данное имя
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

    public HashSet<Edge> getOutcomes(String name){
        if(name != null) {
            HashSet<Edge> edges = new HashSet();
            for(Edge e: this.edges){
                if(e.getStart().getName().equals(name)) {
                    edges.add(e); // Если дуга начинается с этой вершины, добавляем в список
                }
            }
            return edges;
        }
        return null;
    }

    public HashSet<Edge> getIncomes(String name){
        if(name != null) {
            HashSet<Edge> edges = new HashSet();
            for(Edge e: this.edges){
                if(e.getEnd().getName().equals(name)) {
                    edges.add(e); // Если дуга оканчивается этой вершиной, добавляем в список
                }
            }
            return edges;
        }
        return null;
    }

    @Override
    public String toString() {
        return "DirectedGraph{ vertices = " + vertices + ", edges = " + edges + '}';
    }
}
