/*
 *######################################################
 *#                                                    #
 *#                   Liam McMahan                     #
 *#                                                    #
 *######################################################
 */
package csc241hw07;
public class Main {
    public static void main(String[] args) {
        
        //create verticies
        Vertex v1=new Vertex(1);
        Vertex v2=new Vertex(2);
        Vertex v3=new Vertex(3);
        Vertex v4=new Vertex(4);
        Vertex v5=new Vertex(5);
        
        //add edges between the edges
        v1.addEdge(v4);
        v4.addEdge(v3);
        v4.addEdge(v5);
        v3.addEdge(v1);
        v3.addEdge(v2);
        v1.addEdge(v5);
        
        //depthFirstSearch
        System.out.println("v1.breadthFirstSearch() returns...");
        v1.breadthFirstSearch();
        System.out.println("");
    }
}
