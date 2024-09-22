import java.util.*;

public class Graph {
    private Map<Integer, ArrayList<Integer>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    public void addEdge(int source, int destination) {
        adjacencyList.computeIfAbsent(source, k -> new ArrayList<>()).add(destination);
        // If your graph is undirected, uncomment the line below:
        // adjacencyList.computeIfAbsent(destination, k -> new ArrayList<>()).add(source);
    }

    public void displayGraph() {
        for (Map.Entry<Integer, ArrayList<Integer>> entry : adjacencyList.entrySet()) {
            int vertex = entry.getKey();
            ArrayList<Integer> neighbors = entry.getValue();
            System.out.print(vertex + " -> ");
            for (int neighbor : neighbors) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }


    public int countReachableVerticesDFS(int startVertex) {
       //new stack, hashset
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        
        //add starting vertex
        stack.push(startVertex);
        visited.add(startVertex);
    
        //when this is done, dfs is done and we can return the length of the hashset
        while (!stack.isEmpty()) {


            // grab next item off the stack
            int currentVertex = stack.pop();
            
            // get the neighbors for the current vertex
            ArrayList<Integer> neighbors = adjacencyList.get(currentVertex);
            //if null, we can grab the next one off the stack
            if (neighbors != null) {
                
                //do all the neighbors, add them to stack and hashset
                for (int i = 0; i < neighbors.size(); i++) {


                    //if not in the hashset yet (havent added to stack either)
                    if (!visited.contains(neighbors.get(i))) {
                        stack.push(neighbors.get(i));
                        visited.add(neighbors.get(i));
                    }
                }
            }
        }
        
        // return the size - 1 to account for the initial vertex
        return visited.size() - 1;
    }
    public static void main(String[] args) {
        Graph graph = new Graph();

        // Example graph connections
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);

        // Display the graph
        System.out.println("Graph:");
        graph.displayGraph();

        // Count reachable vertices using DFS
        int startVertex = 0;
        int reachableCount = graph.countReachableVerticesDFS(startVertex);
        System.out.println("\nNumber of vertices reachable from vertex " + startVertex + ": " + reachableCount);
    }
}
