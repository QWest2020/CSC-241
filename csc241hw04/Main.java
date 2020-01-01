/*
 *######################################################
 *#                                                    #
 *#                   Liam McMahan                     #
 *#                                                    #
 *######################################################
 */
package csc241hw04;
public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst1 = new BinarySearchTree();
        
        //Add the letters
        bst1.insert("L");
        bst1.insert("J");
        bst1.insert("P");
        bst1.insert("C");
        bst1.insert("K");
        bst1.insert("N");
        bst1.insert("S");
        bst1.insert("A");
        bst1.insert("G");
        bst1.insert("Q");
        bst1.insert("U");
        
        //in order
        System.out.println("In Order Sort");
        System.out.println(bst1.inOrder());
        System.out.println("");
        
        //pre order
        System.out.println("Pre Order Sort");
        System.out.println(bst1.preOrder());
        System.out.println("");
        
        //post order
        System.out.println("Post Order Sort");
        System.out.println(bst1.postOrder());
        System.out.println("");
        
        System.out.println("In order after L is removed");
        bst1.remove("L");
        System.out.println(bst1.inOrder());
        System.out.println("");
    }
}
