package ca.bytetube._12_greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class IPO {
    public static void main(String[] args) throws Exception {
        int[] costs = {10,100,50,500,130};
        int[] profits = {2,40,35,15,40};
        int k = 5;
        int m = 1100;
        int money = IPO(costs, profits, k, m);
        System.out.println("total money: "+ money);
    }

    private static class Element{
        public int cost;
        public int profit;

        public Element(int cost, int profit) {
            this.cost = cost;
            this.profit = profit;
        }

        @Override
        public String toString() {
            return "Element{" +
                    "cost=" + cost +
                    ", profit=" + profit +
                    '}';
        }
    }


    public static int IPO(int[] costs, int[] profits, int k, int m) throws Exception {
        if (costs == null && profits == null && costs.length != profits.length) throw new Exception("error data");
        if (costs.length < 1) return m;

        Element[] elements = new Element[costs.length];
        for (int i = 0; i < elements.length; i++) {
            elements[i] = new Element(costs[i],profits[i]);
        }

        PriorityQueue<Element> minCostQ = new PriorityQueue<>(new Comparator<Element>() {
            @Override
            public int compare(Element o1, Element o2) {
                return o1.cost - o2.cost;
            }
        });

        for (int i = 0; i < elements.length; i++) {
            minCostQ.offer(elements[i]);
        }
        System.out.println("minCostQ: "+minCostQ + "minCostQ size :" + minCostQ.size());

        PriorityQueue<Element> maxProfitQ = new PriorityQueue<>(new Comparator<Element>() {
            @Override
            public int compare(Element o1, Element o2) {
                return o2.profit - o1.profit;
            }
        });



        for (int i = 0; i < k; i++) {
            while (!minCostQ.isEmpty() && minCostQ.peek().cost <= m){
                maxProfitQ.add(minCostQ.poll());
            }
            System.out.println("maxProfitQ: "+ maxProfitQ + "maxProfitQ size :" + maxProfitQ.size());
           int curProfit =  maxProfitQ.poll().profit;
            System.out.println("current money:" + m);
            m += curProfit;
            //System.out.println(curProfit);

        }

        return m;
    }
}
