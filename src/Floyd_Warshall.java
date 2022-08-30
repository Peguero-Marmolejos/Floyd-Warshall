// A Java program for Floyd Warshall All Pairs Shortest 
// Path algorithm. 
import java.util.*; 
import java.io.*;
import java.time.*; 
  
class Floyd_Warshall{ 
    
	public static int INF = 99999, numComparisons = 0, shortComparisons = 0, time2; 
  
    void FloydWarshall(int graph[][], int v) throws IOException { 
        int dist[][] = new int[v][v]; 
        int i, j, k; 
  
        /* Initialize the solution matrix same as input graph matrix. 
           Or we can say the initial values of shortest distances 
           are based on shortest paths considering no intermediate 
           vertex. */
        for (i = 0; i < v; i++) { 
        	numComparisons++;
        	shortComparisons++;
            for (j = 0; j < v; j++) {
                dist[i][j] = graph[i][j]; 
        		numComparisons++;
                shortComparisons++;
            }
        }
        /* Add all vertices one by one to the set of intermediate 
           vertices. 
          ---> Before start of an iteration, we have shortest 
               distances between all pairs of vertices such that 
               the shortest distances consider only the vertices in 
               set {0, 1, 2, .. k-1} as intermediate vertices. 
          ----> After the end of an iteration, vertex no. k is added 
                to the set of intermediate vertices and the set 
                becomes {0, 1, 2, .. k} */
        for (k = 0; k < v; k++){ 
        	numComparisons++;
        	shortComparisons++;
            // Pick all vertices as source one by one 
            for (i = 0; i < v; i++) { 
            	numComparisons++;
            	shortComparisons++;
                // Pick all vertices as destination for the 
                // above picked source 
                for (j = 0; j < v; j++) { 
                	numComparisons++;
                	shortComparisons++;
                    // If vertex k is on the shortest path from 
                    // i to j, then update the value of dist[i][j] 
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j]; 
                    	numComparisons++;
                        shortComparisons++;
                    }
                } 
            } 
        } 
  
        // Print the shortest distance matrix 
        printSolution(dist, v); 
    } 
  
    void printSolution(int dist[][], int v) throws IOException 
    { 
       writeToFile("The following matrix shows the shortest "+ 
                         "distances between every pair of vertices \n"); 
        for (int i=0; i<v; ++i) 
        { numComparisons++;
            for (int j=0; j<v; ++j) 
            { numComparisons++;
                if (dist[i][j]==INF) { 
                    writeToFile("INF "); 
                    numComparisons++;
                }
                else {
                    writeToFile(dist[i][j]+"   "); 
                    numComparisons++;
                }
            } 
            writeToFile("\n"); 
        } 
        //this is how I randomly generate a graph, with values between 0 and 979
    } 
    
    public static int[][] createRandomGraph980(int a) { // a represents the number of vertices, function creates a graph with a larger range value 
    	int [][] graph = new int[a][a];
    	for(int i = 0; i< a; i++) {
    		numComparisons++;
   			for(int j = 0; j < a ; j++) {
   				numComparisons++;
   					if(i == j ) {
   						graph[i][j] = 0; // no paths to your own vertex
   						numComparisons++;
   		    		}else {
   		    			numComparisons++;
   		    			Random random = new Random();
   		    			int randomWeight = random.nextInt(1000);
   		    			if(randomWeight >= 980 || randomWeight == 0) {// some paths don't exist
   		    				graph [i][j] = INF;
   		    				numComparisons++;
   		    			}else {
   		    				graph[i][j] = randomWeight;
   		    				numComparisons++;
   		    			}
   		    		}
    		}
   		}
    	return graph;
    }
    
    public static int[][] createRandomGraph480(int a) { // a represents the number of vertices, creates graph with medium range values
    	int [][] graph = new int[a][a];
    	for(int i = 0; i< a; i++) {
    		numComparisons++;
   			for(int j = 0; j < a ; j++) {
   				numComparisons++;
   					if(i == j ) {
   						graph[i][j] = 0; // no paths to your own vertex
   						numComparisons++;
   		    		}else {
   		    			numComparisons++;
   		    			Random random = new Random();
   		    			int randomWeight = random.nextInt(500);
   		    			if(randomWeight >= 480 || randomWeight == 0) {// some paths don't exist
   		    				graph [i][j] = INF;
   		    				numComparisons++;
   		    			}else {
   		    				numComparisons++;
   		    				graph[i][j] = randomWeight;
   		    			}
   		    		}
    		}
   		}
    	return graph;
    }
    
    public static int[][] createRandomGraph80(int a) { // a represents the number of vertices, creates a graph with small range value0--80
    	int [][] graph = new int[a][a];
    	for(int i = 0; i< a; i++) {
    		numComparisons++;
   			for(int j = 0; j < a ; j++) {
   				numComparisons++;
   					if(i == j ) {
   						numComparisons++;
   						graph[i][j] = 0; // no paths to your own vertex
   		    		}else {
   		    			numComparisons++;
   		    			Random random = new Random();
   		    			int randomWeight = random.nextInt(100);
   		    			if(randomWeight >= 80 || randomWeight == 0) {// some paths don't exist
   		    				graph [i][j] = INF;
   		    				numComparisons++;
   		    			}else {
   		    				numComparisons++;
   		    				graph[i][j] = randomWeight;
   		    			}
   		    		}
    		}
   		}
    	return graph;
    }
    
    public static void readGraph(int[][] g, int a) throws IOException {
    	for(int i = 0; i < a; i++) {
    		numComparisons++;
    		for(int j = 0; j < a; j++) {
    			numComparisons++;
    			if(g[i][j] == INF) {
    				numComparisons++;
    				writeToFile("INF ,");
    			}else {
    				numComparisons++;
        			writeToFile(g[i][j]+ " ,");
    			}
    		}
    		writeToFile("\n");
    	}
    }
    
    public static void writeToFile(String a) throws IOException {
    	
    	File file = new File("FloydWarsallOutput.txt");
    	FileWriter fr = new FileWriter(file, true);
    	fr.write(a);
    	fr.close();
    }
    // Driver program to test above function 
    //Initial code provided by Aakash Hasija via geeks for geeks
    public static void main (String[] args) throws IOException 
    { 	
    	Instant start = Instant.now();

    	writeToFile("Floyd-Warshall Algorithm \n");
       /* int graph[][] = { {0,   5,  INF, 10}, 
                          {INF, 0,   3, INF}, 
                          {INF, INF, 0,   1}, 
                          {INF, INF, INF, 0} 
                        }; */
        Floyd_Warshall a = new Floyd_Warshall(); 
        int  graph10 [][] = createRandomGraph80(10);
        //int graph100 [][] = createRandomGraph480(100);
        //int graph1000[][] = createRandomGraph80(1000);
        //int graph10000[][] = createRandomGraph480(10000);
        	
        //Geeks for Geeks simple example:
      /*  readGraph(graph,4);
        System.out.println();
        a.FloydWarshall(graph, 4);
        System.out.println();*/

        writeToFile("Graph of N = 10 \n");
        readGraph(graph10, 10);
        writeToFile("\n");
    	Instant start2 = Instant.now();
        a.FloydWarshall(graph10, 10);
        
        Instant end = Instant.now();
        writeToFile("\n");
        
        /*writeToFile("Graph of N = 100 \n");
        readGraph(graph100, 100);
        writeToFile("\n");
        Instant start2 = Instant.now();
        a.FloydWarshall(graph100, 100);
        Instant end = Instant.now();
        writeToFile("\n");*/
        
        
        /*writeToFile("Graph of N= 1000 \n");
        readGraph(graph1000, 1000);
        writeToFile("\n");
        Instant start2 = Instant.now();
        a.FloydWarshall(graph1000, 1000);
        Instant end = Instant.now();
        writeToFile("\n");*/
        
        
        /*writeToFile("Graph of N= 10000 \n");
        readGraph(graph10000, 10000);
        writeToFile("\n");
        Instant start2 = Instant.now();
        a.FloydWarshall(graph10000, 10000);
        Instant end = Instant.now();
        writeToFile("\n");*/
        
        
        
        // Print the solution 

        

        
        Duration timeElapsed = Duration.between(start, end);
        Duration dur2 = Duration.between(start2,end);

        writeToFile("\nTotal Time taken: "+ timeElapsed.toMillis() +" milliseconds ");
        writeToFile("\nTime taken to find solution: " + dur2.toMillis() + " milliseconds ");
        writeToFile("\n Total comparisons for creating graph, showing graph, and finding the shortest path : " + numComparisons);
	    writeToFile("\n Number of comparisons for finding shortest path : " + shortComparisons);

	    System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds ");
	    System.out.println("Time taken to find solution: " + dur2.toMillis() + " milliseconds ");
	    System.out.println("Total comparisons for creating graph, showing graph, and finding the shortest distance : " + numComparisons);
	    System.out.println("Number of comparisons for finding shortest path : " + shortComparisons);

    } 
} 