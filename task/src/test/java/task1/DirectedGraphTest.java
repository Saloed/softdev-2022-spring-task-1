package task1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.HashMap;
import java.util.HashSet;


class DirectedGraphTest {

    @Test
    void getVertices() {
        DirectedGraph graph = new DirectedGraph();
        Vertex a = new Vertex("a");
        Vertex b = new Vertex("b");
        Vertex c = new Vertex("c");
        graph.addVertex(a);
        graph.addVertex(b);
        graph.addVertex(c);
        HashMap<String, Vertex> expectedVertices = new HashMap<>();
        expectedVertices.put("a", a);
        expectedVertices.put("b", b);
        expectedVertices.put("c", c);
        assertEquals(expectedVertices, graph.getVertices());
    }

    @Test
    void getEdges() {
        DirectedGraph graph = new DirectedGraph();
        Vertex a = new Vertex("a");
        Vertex b = new Vertex("b");
        Vertex c = new Vertex("c");
        graph.addVertex(a);
        graph.addVertex(b);
        graph.addVertex(c);
        Edge ac = new Edge(a, b, 2);
        Edge bc = new Edge(a, c, 3);
        Edge ca = new Edge(c, a, 4);
        graph.addEdge(ac);
        graph.addEdge(bc);
        graph.addEdge(ca);
        HashSet<Edge> expectedEdges = new HashSet<>();
        expectedEdges.add(ac);
        expectedEdges.add(bc);
        expectedEdges.add(ca);
        assertEquals(expectedEdges, graph.getEdges());
    }

    @Test
    void getOutcomes() {
        DirectedGraph graph = new DirectedGraph();
        Vertex a = new Vertex("a");
        Vertex b = new Vertex("b");
        Vertex c = new Vertex("c");
        graph.addVertex(a);
        graph.addVertex(b);
        graph.addVertex(c);
        Edge ac = new Edge(a, b, 2);
        Edge bc = new Edge(a, c, 3);
        Edge ca = new Edge(c, a, 4);
        graph.addEdge(ac);
        graph.addEdge(bc);
        graph.addEdge(ca);
        HashSet<Edge> expectedOutcomes = new HashSet<>();
        expectedOutcomes.add(ac);
        expectedOutcomes.add(bc);
        assertEquals(expectedOutcomes, graph.getOutcomes("a"));

    }

    @Test
    void getIncomes() {
        DirectedGraph graph = new DirectedGraph();
        Vertex a = new Vertex("a");
        Vertex b = new Vertex("b");
        Vertex c = new Vertex("c");
        graph.addVertex(a);
        graph.addVertex(b);
        graph.addVertex(c);
        Edge ac = new Edge(a, c, 2);
        Edge bc = new Edge(b, c, 3);
        Edge ca = new Edge(c, a, 4);
        graph.addEdge(ac);
        graph.addEdge(bc);
        graph.addEdge(ca);
        HashSet<Edge> expectedIncomes = new HashSet<>();
        expectedIncomes.add(ac);
        expectedIncomes.add(bc);
        assertEquals(expectedIncomes, graph.getIncomes("c"));
    }
}