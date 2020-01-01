/*
 *######################################################
 *#                                                    #
 *#                   Liam McMahan                     #
 *#                                                    #
 *######################################################
 */
package csc241hw04;
public class BinarySearchTree {
    
    //the tree starts with a root
    TreeNode root;
    
    //constructor
    public BinarySearchTree(){
        root=null;
    }
    
    //insert
    public void insert(String v){
        if(root==null){ //no root
            //new node
            root=new TreeNode(v);
        }
        else
            //find this Node's place in the tree!
            root.insert(v);
    }
    
    //inOrder
    public String inOrder(){
        if(root!=null)
            return root.inOrder();
        else
            return null;
    }
    
    //preOrder
    public String preOrder(){
        if(root!=null)
            return root.preOrder();
        else
            return null;
    }
    
    //postOrder
    public String postOrder(){
        if(root!=null)
            return root.postOrder();
        else
            return null;
    }
    
    // Check if a value is contained in the tree
    public boolean contains(String v) {
        // check for an empty tree
        if (root == null) {
            // empty
            return false;
        } else {
            return root.contains(v);
        }
    }
    
    // Remove a value from the tree
    public void remove(String v) {
        if (root != null) {
            root = root.remove(v);
        }
    }
}