package ca.bytetube._12_greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Knapsack {
    public static void main(String[] args) {
        Article[] articles = new Article[]{
                new Article(35,10),new Article(30,40),
                new Article(60,30),new Article(50,50),
                new Article(40,35),new Article(10,40),
                new Article(25,30)};
        select(articles, new Comparator<Article>() {
            @Override
            public int compare(Article o1, Article o2) {
                return o1.weight - o2.weight;
            }
        });
        System.out.println("=======================");

        select(articles, new Comparator<Article>() {
            @Override
            public int compare(Article o1, Article o2) {
                return o2.value - o1.value;
            }
        });

        System.out.println("=======================");

        select(articles, new Comparator<Article>() {
            @Override
            public int compare(Article o1, Article o2) {
                return Double.compare(o2.density , o1.density);
            }
        });
    }



    public static void select(Article[] articles, Comparator<Article> comparator){
        if (articles == null || articles.length == 0 || comparator == null) return;

        Arrays.sort(articles,comparator);
        int weight = 0;
        int capacity = 150;
        int value = 0;
        List<Article> selected = new LinkedList<>();
        for (int i = 0; i < articles.length ; i++) {
            int newWeight = articles[i].weight + weight;
            if (newWeight <= capacity) {
                weight = newWeight;
                value += articles[i].value;
                selected.add(articles[i]);
            }

        }

        System.out.println(value);
        System.out.println(selected);

    }

}
