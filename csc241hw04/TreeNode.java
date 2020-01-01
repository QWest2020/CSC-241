/*
 *######################################################
 *#                                                    #
 *#                   Liam McMahan                     #
 *#                                                    #
 *######################################################
 */
package csc241hw04;

import java.util.Random;

public class TreeNode {

    //value
    String value;

    //child references
    TreeNode left;
    TreeNode right;

    //Constructor
    public TreeNode(String v) {
        value = v;
        //sets both to null! (A little piece of Java Sugar! :) )
        left = right = null;
    }

    //insert 
    public void insert(String v) {
        if (value.compareTo(v) >= 0) {
            //left child
            if (left == null) { //terminating condtition
                //new left child
                left = new TreeNode(v);
            } else //insert from reference of this left child! DELEGATE
            //delegating condition
            {
                left.insert(v);
            }
        } else {
            //right child
            if (right == null) {
                //new right child
                right = new TreeNode(v);
            } else //insert from reference of this right child! DELEGATE
            {
                right.insert(v);
            }
        }
    }

    // Check if value is in the tree
    public boolean contains(String v) {
        if (value.equals(v)) {
            // Value found in the current node
            return true;
        } else if (value.compareTo(v) >= 0) {
            // Value could be in left subtree
            if (left == null) {
                // No left child
                return false;
            } else {
                // Delegate to left child
                return left.contains(v);
            }
        } else {
            // Value could be in the right subtree
            if (right == null) {
                // No right child
                return false;
            } else {
                // Delegate to right child
                return right.contains(v);
            }
        }
    }

    // Remove a value from the tree
    public TreeNode remove(String v) {
        // check the subtrees
        if (left != null && value.compareTo(v) > 0) {
            // ask left child to remove value
            left = left.remove(v);
        } else if (right != null && value.compareTo(v) < 0) {
            // ask right child to remove value
            right = right.remove(v);
        } else {
            // Current node getting removed
            if (left == null && right == null) {
                // Case 1 : no children
                return null;
            } else if (left != null && right == null) {
                // Case 2 - promote left child
                return left;
            } else if (left == null && right != null) {
                // Case 2 - promote right child
                return right;
            } else {
                // Case 3 -- Node with two children
                Random r = new Random();  // Random value generator allows us to maintain a balanced search tree system

                if (r.nextBoolean()) {
                    if (left != null) // get maximum value and remove the duplicate
                    {
                        value = left.rightMost();
                        left = left.remove(value);
                    }
                } else {
                    if (right != null) // get minimum value and remove the duplicate
                    {
                        value = right.leftMost();
                        right = right.remove(value);
                    }
                }

            }
        }
        // Return current reference (may have a new value)        
        return this;
    }

    //leftMost method allows us to find the leftmost node in a subtree
    //protected means that they can only be used by objects in this class
    //we can change these to private since its exclusively used by the TreeNode
    private String leftMost() {
        // returns the left most value
        if (left == null) {
            // no more left children
            return value;
        } else {
            return left.leftMost();
        }
    }

    //rightMost method works similarly to the leftMost method
    private String rightMost() {
        // returns the right most value
        if (right == null) {
            // no more right children
            return value;
        } else {
            return right.rightMost();
        }
    }

    //in order traversal
    public String inOrder() {

        String leftString = "";
        String rightString = "";

        //attempt to go left
        if (left != null) { //we have a left child
            //left subtree traversal
            leftString = left.inOrder();
        }

        //attempt to go right
        if (right != null) {
            //right subtree traversal
            rightString = right.inOrder();
        }

        //in traversal order
        return leftString + "[" + value + "]" + rightString;
    }

    //pre order traversal
    public String preOrder() {

        String leftString = "";
        String rightString = "";

        //attempt to go left
        if (left != null) { //we have a left child
            //left subtree traversal
            leftString = left.preOrder();
        }

        //attempt to go right
        if (right != null) {
            //right subtree traversal
            rightString = right.preOrder();
        }

        //pretraversal order
        return "[" + value + "]" + leftString + rightString;
    }

    //post order traversal
    public String postOrder() {

        String leftString = "";
        String rightString = "";

        //attempt to go left
        if (left != null) { //we have a left child
            //left subtree traversal
            leftString = left.postOrder();
        }

        //attempt to go right
        if (right != null) {
            //right subtree traversal
            rightString = right.postOrder();
        }

        //post traversal order
        return leftString + rightString + "[" + value + "]";
    }
}
