package ca.bytetube._09_graph;


import java.util.*;

public class ListGraph<V, E> implements Graph<V, E> {
    private Map<V, Vertex<V, E>> vertices = new HashMap<>();

    private Set<Edge<V, E>> edges = new HashSet<>();

    public ListGraph() {
    }


    @Override
    public int verticesSize() {
        return vertices.size();
    }

    @Override
    public int edgesSize() {
        return edges.size();
    }

    @Override
    public void addVertex(V v) {
        if (vertices.containsKey(v)) return;
        vertices.put(v, new Vertex<>(v));

    }


    @Override
    public void addEdge(V fromV, V toV) {
        addEdge(fromV, toV, null);
    }

    @Override
    public void addEdge(V from, V to, E weight) {//V0---V4 --- 10
        //1.先判断from，to顶点是否存在
        Vertex<V, E> fromVertex = vertices.get(from);
        if (fromVertex == null) {
            fromVertex = new Vertex<>(from);
            vertices.put(from, fromVertex);
        }

        Vertex<V, E> toVertex = vertices.get(to);
        if (toVertex == null) {
            toVertex = new Vertex<>(to);

            vertices.put(to, toVertex);
        }

        //代码能来到这里，说明一定可以保证这条边有起点和终点
        //接下来需要确定这2个点之间是否已经存在边，如果不存在，则新建一条边
        // 如果存在，先删除掉原先的边，再更新weight
        Edge<V, E> edge = new Edge<>(fromVertex, toVertex);
        edge.weight = weight;
        if (fromVertex.outDegrees.remove(edge)) {
            toVertex.inDegrees.remove(edge);
            edges.remove(edge);
        }
        fromVertex.outDegrees.add(edge);
        toVertex.inDegrees.add(edge);
        edges.add(edge);

    }

    @Override
    public void removeEdge(V fromV, V toV) {

    }

    @Override
    public void removeVertex(V v) {

    }


    public void printGraph() {
        System.out.println("[vertices]----------------------");
        vertices.forEach((V v, Vertex<V, E> vertex) -> {
            System.out.println(v);
            System.out.println("in---------------------");
            System.out.println(vertex.inDegrees);
            System.out.println("out---------------------");
            System.out.println(vertex.outDegrees);
        });

        System.out.println("[edges]----------------------");
        edges.forEach((Edge<V, E> edge) -> {
            System.out.println(edge);
        });
    }

    private static class Vertex<V, E> {
        V value;

        Set<Edge<V, E>> inDegrees = new HashSet<>();

        Set<Edge<V, E>> outDegrees = new HashSet<>();

        public Vertex(V value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            return Objects.equals(this.value, ((Vertex<V, E>) o).value);
        }

        @Override
        public int hashCode() {
            return this.value == null ? 0 : value.hashCode();
        }

        @Override
        public String toString() {
            return this.value == null ? "null" : value.toString();
        }
    }


    private static class Edge<V, E> {
        E weight;
        Vertex<V, E> from;
        Vertex<V, E> to;

        public Edge(Vertex<V, E> from, Vertex<V, E> to) {
            this.from = from;
            this.to = to;
            weight = null;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Edge<?, ?> edge = (Edge<?, ?>) o;
            return Objects.equals(from, edge.from) &&
                    Objects.equals(to, edge.to);
        }

        @Override
        public int hashCode() {
            return from.hashCode() * 31 + to.hashCode();
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "from=" + from +
                    ",to=" + to +
                    ",weight=" + weight +
                    '}';
        }
    }
}
