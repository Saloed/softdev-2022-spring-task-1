package task1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.HashMap;
import java.util.HashSet;


class DirectedGraphTest {

    @Test
    void getVertices() {
        HashMap<String, Vertex> vertices = new HashMap();
        vertices.put("a", new Vertex("a"));
        vertices.put("b", new Vertex("b"));
        vertices.put("c", new Vertex("c"));
        DirectedGraph graph = new DirectedGraph(vertices, new HashSet());
        HashMap<String, Vertex> expectedVertices = vertices;
        assertEquals(expectedVertices, graph.getVertices());
    }

    @Test
    void getEdges() {
        HashMap<String, Vertex> vertices = new HashMap();
        vertices.put("a", new Vertex("a"));
        vertices.put("b", new Vertex("b"));
        vertices.put("c", new Vertex("c"));
        HashSet<Edge> edges = new HashSet();
        edges.add(new Edge(vertices.get("a"), vertices.get("b"), 2));
        edges.add(new Edge(vertices.get("b"), vertices.get("c"), 3));
        edges.add(new Edge(vertices.get("c"), vertices.get("a"), 4));
        DirectedGraph graph = new DirectedGraph(vertices, edges);
        HashSet<Edge> expectedEdges = edges;
        assertEquals(edges, graph.getEdges());
    }

    @Test
    void getOutcomes() {
        HashMap<String, Vertex> vertices = new HashMap();
        vertices.put("a", new Vertex("a"));
        vertices.put("b", new Vertex("b"));
        vertices.put("c", new Vertex("c"));
        HashSet<Edge> edges = new HashSet();
        Edge ab = new Edge(vertices.get("a"), vertices.get("b"), 2);
        Edge ac = new Edge(vertices.get("a"), vertices.get("c"), 3);
        Edge ca = new Edge(vertices.get("c"), vertices.get("a"), 4);
        edges.add(ab);
        edges.add(ac);
        edges.add(ca);
        DirectedGraph graph = new DirectedGraph(vertices, edges);
        HashSet<Edge> expectedOutcome = new HashSet();
        expectedOutcome.add(ab);
        expectedOutcome.add(ac);
        assertEquals(expectedOutcome, graph.getOutcomes("a"));
    }

    @Test
    void getIncomes() {
        HashMap<String, Vertex> vertices = new HashMap();
        vertices.put("a", new Vertex("a"));
        vertices.put("b", new Vertex("b"));
        vertices.put("c", new Vertex("c"));
        HashSet<Edge> edges = new HashSet();
        Edge ac = new Edge(vertices.get("a"), vertices.get("c"), 2);
        Edge bc = new Edge(vertices.get("b"), vertices.get("c"), 3);
        Edge ca = new Edge(vertices.get("c"), vertices.get("a"), 4);
        edges.add(ac);
        edges.add(bc);
        edges.add(ca);
        DirectedGraph graph = new DirectedGraph(vertices, edges);
        HashSet<Edge> expectedIutcome = new HashSet();
        expectedIutcome.add(ac);
        expectedIutcome.add(bc);
        assertEquals(expectedIutcome, graph.getIncomes("c"));
    }
}