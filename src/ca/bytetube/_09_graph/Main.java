package ca.bytetube._09_graph;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

//        Set<String> set = new HashSet<>();
//        set.add("s1");
//        set.add("s2");
//        set.add("s3");
//        set.add("s4");
//        System.out.println(set);
       test();
    }


    public static void test(){
        ListGraph<Object,Object> graph = new ListGraph<>();
        graph.addEdge("V0","V4",6);
        graph.addEdge("V1","V0",9);
        graph.addEdge("V1","V2",3);
        graph.addEdge("V2","V3",5);
        graph.addEdge("V2","V0",2);
        graph.addEdge("V3","V4",1);
        graph.printGraph();

    }
}
