/*
 *######################################################
 *#                                                    #
 *#                   Liam McMahan                     #
 *#                                                    #
 *######################################################
 */
package csc241hw07;

import java.util.ArrayList;

public class Vertex {
    //A vertex is like a Node in a graph

    //instance variables
    int value;
    ArrayList<Vertex> adjacent;
    //THIS BOOLEAN WILL SAVE YOUR LIFE WHEN IT COMES TO THE BREADTH SEARCH!!!
    boolean checked=false;

    //Constructor
    public Vertex(int v) {
        //initialize
        value = v;
        adjacent = new ArrayList<Vertex>();
        //adjacents are empty
    }

    //add an edge
    public void addEdge(Vertex v) {
        //add to adjacent
        adjacent.add(v);
    }

    //depthFirstSearch method. initialize visited
    public void depthFirstSearch() {
        // create an empty "visited" list
        ArrayList<Vertex> visited = new ArrayList<Vertex>();
        // start the recursive depth first search on the current vertex
        this.dfs(visited);
    }

    //dfs method. visit each vertex
    private void dfs(ArrayList<Vertex> visit) {
        // visit this node
        System.out.print("[" + value + "]");
        // add it to visited
        visit.add(this);

        // recursively visit each adjacent node
        for (Vertex v : adjacent) {
            if (!visit.contains(v)) {
                // vertex has not yet been visited
                v.dfs(visit);
            }
        }
    }

    public void breadthFirstSearch() {
        // create an empty "visited" list
        ArrayList<Vertex> visited = new ArrayList<Vertex>();
        // visit this node
        System.out.print("[" + value + "]");
        // add it to visited
        visited.add(this);
        this.checked=true;
        // start the recursive depth first search on the current vertex
        this.bfs(visited);
    }

    private void bfs(ArrayList<Vertex> visit) {
        //visit the adjacents first
        for (Vertex v : adjacent) {
            if (!visit.contains(v)) {
                // visit this node
                System.out.print("[" + v.value + "]");
                // add it to visited
                visit.add(v);
            }
        }
        //this node has done the bfs
        this.checked=true;
        
        //then bfs the adjacents
        for (Vertex v : adjacent) {
            if(!v.checked)
            v.bfs(visit);
        }
    }
}
