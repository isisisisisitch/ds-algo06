package ca.bytetube._06_avlTree;


import ca.bytetube._06_avlTree.printer.BinaryTrees;

public class Main {


    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        AVLTree<Integer> avlTree = new AVLTree<>();
        avlTree.add(13);

        avlTree.add(14);


        avlTree.add(15);

        avlTree.add(12);

        avlTree.add(11);

        avlTree.add(17);

        avlTree.add(16);

        avlTree.add(8);

        avlTree.add(9);

        avlTree.add(1);
        BinaryTrees.println(avlTree);
        System.out.println("=====================");
        avlTree.remove(1);
        BinaryTrees.println(avlTree);
        System.out.println("=====================");
        avlTree.remove(8);
        BinaryTrees.println(avlTree);
        System.out.println("=====================");
        avlTree.remove(13);
        BinaryTrees.println(avlTree);

//        String str = BinaryTrees.printString(bst);
//        str += "\n";
//        Files.writeToFile("/Users/dalluo/Desktop/test.txt",str,true);
       // BinaryTrees.println(avlTree);

        //bst.predecessor(8);
//        avlTree.remove(7);

//        System.out.println(avlTree.contains(7));

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
