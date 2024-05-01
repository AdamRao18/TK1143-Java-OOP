
import java.util.InputMismatchException;
import java.util.Scanner;

public class Malacca {
	 public static void main(String... arg)
	    {
	        int adjacency_matrix[][];       

	        int number_of_vertices;
	        int source = 0, destination = 0;
	        Scanner scan = new Scanner(System.in);     
	           
	        number_of_vertices = 6;
	        String area[] = {"Masjid Tanah", "Alor Gajah", "Tangga Batu", "Bukit Katil", "Kota Melaka", "Jasin"};
	        adjacency_matrix = new int [][] {
	        	{0, 14, 15, 0, 0, 0},
	        	{14, 0, 25, 27, 0, 32},
	        	{15, 25, 0, 23, 16, 0},
	        	{0, 27, 23, 0, 10, 21},
	        	{0, 0, 16, 10, 0, 31},
	        	{0, 32, 0, 21, 31, 0}};      	
	        
            source = scan.nextInt();
            destination = scan.nextInt();
	               
	         Dijkstra dijkstrasAlgorithm = new Dijkstra(number_of_vertices);
	         dijkstrasAlgorithm.dijkstra_algorithm(adjacency_matrix, source);
	 
	         System.out.print("The Shorted Path from " );
	         for (int i = 0; i < dijkstrasAlgorithm.distances.length ; i++)
	         {
	            if (i == destination)
	                    System.out.println(area[source] + " to " + area[i] + " is "
	                            + dijkstrasAlgorithm.distances[i] + " km");
	            }
	       
	    }
}
