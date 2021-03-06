package ca.bytetube._09_graph;

public interface Graph<V, E> {

    int verticesSize();

    int edgesSize();

    void addVertex(V v);//"V0"

    void removeVertex(V v);

    void addEdge(V fromV, V toV);

    void addEdge(V fromV, V toV, E weight);

    void removeEdge(V fromV, V toV);

    void bfs(V begin);

    void dfs(V begin);

    void bfs(V begin, VertexVisitor<V> visitor);

    void dfs(V begin, VertexVisitor<V> visitor);

    public interface VertexVisitor<V> {
        public boolean visit(V v);
    }


}
