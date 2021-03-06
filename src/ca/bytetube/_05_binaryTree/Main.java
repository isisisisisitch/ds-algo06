package ca.bytetube._05_binaryTree;

import ca.bytetube._05_binaryTree.file.Files;
import ca.bytetube._05_binaryTree.printer.BinaryTrees;

public class Main {


    public static void main(String[] args) {
        //BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        test3();
    }


    public static void test1(){
        int[] arr = {7,4,9,2,5,8,11,1,3,12};
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (int i = 0; i < arr.length; i++) {
            bst.add(arr[i]);
        }

//        String str = BinaryTrees.printString(bst);
//        str += "\n";
//        Files.writeToFile("/Users/dalluo/Desktop/test.txt",str,true);
        BinaryTrees.println(bst);

         //bst.predecessor(8);
        bst.remove(7);
        BinaryTrees.println(bst);
        System.out.println(bst.contains(7));

    }

    public static void test2(){
        int[] arr = {7,4,9,2,5,8,11,1,3,12};
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (int i = 0; i < arr.length; i++) {
            bst.add(arr[i]);
        }

        System.out.println(bst.height());
    }

    public static void test3(){
        int[] arr = {7,4,9,2,5,8,11,1,3};
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (int i = 0; i < arr.length; i++) {
            bst.add(arr[i]);
        }

        BinaryTrees.println(bst);
    }


}
