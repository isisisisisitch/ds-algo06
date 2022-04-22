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
    public void removeEdge(V from, V to) {
        Vertex<V, E> fromVertex = vertices.get(from);
        if (fromVertex == null) return;
        Vertex<V, E> toVertex = vertices.get(to);
        if (toVertex == null) return;

        //代码能够来到这，说明起点和终点都存在，但是不代表2个顶点之间存在边
        Edge<V, E> edge = new Edge<>(fromVertex, toVertex);
        if (fromVertex.outDegrees.remove(edge)) {
            toVertex.inDegrees.remove(edge);
            edges.remove(edge);
        }
    }


    @Override
    public void removeVertex(V v) {
        Vertex<V, E> vertex = vertices.remove(v);
        if (vertex == null) return;
        //vertex outDegrees
        Set<Edge<V, E>> outDegrees = vertex.outDegrees;
        //在所有的编程语言中，对于容器进行遍历操作时，不能同时做修改操作，否则会破坏容器的原子性,不安全
        //如何解决这个需求（边遍历边删除）：使用迭代器
        //vertex.outDegrees              //V0
        Iterator<Edge<V, E>> iterator = vertex.outDegrees.iterator();
        while (iterator.hasNext()) {
            Edge<V, E> edge = iterator.next();//V0V4
            //通过edge这条边找到这条边的终点，把终点(edge.to)的inDegree删掉
            edge.to.inDegrees.remove(edge);
            //从起点的outDegrees中把这条边删除
            iterator.remove();
            edges.remove(edge);
        }

        //vertex.inDegrees              //V0
        Iterator<Edge<V, E>> iterator2 = vertex.inDegrees.iterator();
        while (iterator2.hasNext()) {
            Edge<V, E> edge = iterator2.next();//V1V0
            //通过edge这条边找到这条边的起点，把起点(edge.from)的outDegrees删掉
            edge.from.outDegrees.remove(edge);
            //从终点的inDegrees中把这条边删除
            iterator2.remove();
            edges.remove(edge);

        }


    }

    @Override
    public void bfs(V begin) {
        Vertex<V, E> beginVertex = vertices.get(begin);
        if (beginVertex == null) return;
        Queue<Vertex<V, E>> queue = new LinkedList<>();
        Set<Vertex<V, E>> visitedVerticesSet = new HashSet<>();//用于记录已经访问过的顶点
        queue.offer(beginVertex);
        visitedVerticesSet.add(beginVertex);
        while (!queue.isEmpty()) {
            Vertex<V, E> poll = queue.poll();
            System.out.println(poll.value);
            for (Edge<V, E> edge : poll.outDegrees) {
                if (visitedVerticesSet.contains(edge.to)) continue;
                queue.offer(edge.to);
                visitedVerticesSet.add(edge.to);
            }
        }


    }

    /**
     * 思路：
     * 1.先将起点（begin）入栈并访问，然后用set将已经访问过的顶点记录，
     * 2.循环往复的做：
         *弹出栈顶vertex，再从当前顶点中取出一条outEdge，将这条边的from,to依次压入栈中
         * 3.访问终点to
         * 4.将终点to加入到set中
         * 5.加入break（不去访问outEdge中的其他边，而是一路访问剩余的顶点）
     */

    @Override
    public void dfs(V begin) {
        Vertex<V, E> beginVertex = vertices.get(begin);
        if (beginVertex == null) return;
        Stack<Vertex<V, E>> stack = new Stack<>();
        Set<Vertex<V, E>> visitedVerticesSet = new HashSet<>();//用于记录已经访问过的顶点
        // 1.先将起点（begin）入栈并访问，然后用set将已经访问过的顶点记录，
        stack.push(beginVertex);
        System.out.println(beginVertex.value);
        visitedVerticesSet.add(beginVertex);
        //2.循环往复的做：弹出栈顶vertex，再从当前顶点中取出一条outEdge，将这条边的from,to依次压入栈中
        while (!stack.isEmpty()) {
            Vertex<V, E> vertex = stack.pop();
            for (Edge<V, E> edge : vertex.outDegrees) {
                if (visitedVerticesSet.contains(edge.to)) continue;
                stack.push(edge.from);
                stack.push(edge.to);
                //3.访问终点to
                System.out.println(edge.to.value);
                //4.将终点to加入到set中
                visitedVerticesSet.add(edge.to);
                break;
            }
        }

    }


    public void dfsByRecursion(V begin) {
        Vertex<V, E> beginVertex = vertices.get(begin);
        if (beginVertex == null) return;
        Set<Vertex<V, E>> visitedVerticesSet = new HashSet<>();//用于记录已经访问过的顶点
        dfs(beginVertex, visitedVerticesSet);

    }

    private void dfs(Vertex<V, E> beginVertex, Set<Vertex<V, E>> visitedVerticesSet) {
        System.out.println(beginVertex.value);
        visitedVerticesSet.add(beginVertex);
        for (Edge<V, E> edge : beginVertex.outDegrees) {
            if (visitedVerticesSet.contains(edge.to)) continue;
            dfs(edge.to, visitedVerticesSet);
        }

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

//        System.out.println("[edges]----------------------");
//        edges.forEach((Edge<V, E> edge) -> {
//            System.out.println(edge);
//        });
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
