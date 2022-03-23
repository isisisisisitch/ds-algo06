package ca.bytetube._06_avlTree;


import ca.bytetube._06_avlTree.printer.BinaryTrees;

public class Main {


    public static void main(String[] args) {
        test1();
    }

    public static void test1(){
        int[] arr = {7,4,9,2,5,8,11,1,3,12};
        AVLTree<Integer> avlTree = new AVLTree<>();
        for (int i = 0; i < arr.length; i++) {
            avlTree.add(arr[i]);
        }

//        String str = BinaryTrees.printString(bst);
//        str += "\n";
//        Files.writeToFile("/Users/dalluo/Desktop/test.txt",str,true);
        BinaryTrees.println(avlTree);

         //bst.predecessor(8);
        avlTree.remove(7);
        BinaryTrees.println(avlTree);
        System.out.println(avlTree.contains(7));

    }

//    public static void test2(){
//        int[] arr = {7,4,9,2,5,8,11,1,3,12};
//        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
//        for (int i = 0; i < arr.length; i++) {
//            bst.add(arr[i]);
//        }
//
//        System.out.println(bst.height());
//    }
//
//    public static void test3(){
//        int[] arr = {7,4,9,2,5,8,11,1,3};
//        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
//        for (int i = 0; i < arr.length; i++) {
//            bst.add(arr[i]);
//        }
//
//        BinaryTrees.println(bst);
//    }


}
