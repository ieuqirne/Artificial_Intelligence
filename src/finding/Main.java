package finding;
import loadingData.loadingFile;
import workingArray.workingArray;
import finding.Cavern;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

	/*
	 * 	Author: Enrique Belenguer 40406742	
	 * 	Description of class: main method
	 * 	Created : 02/11/2018
	 * */
public class Main{

	public static void main(String[] args) throws Exception {
	

		if(args.length < 1) {
	        System.out.println("Error, usage: java ClassName inputfile");
	        System.exit(1);
	    }
		
		//Getting file and dividing name and type
		
		int numCaverns;
		int[][] incidentMatrix;
		int[] coorX,coorY;
		Cavern start, goal;
		loadingFile lf = new loadingFile();
		workingArray wa = new workingArray();
		A_Star_Algorithm aStart = new A_Star_Algorithm();
		List<Cavern> path = new ArrayList<>();
		int [] arrayPath = new int [100];
		


		System.out.println("------- Coursework Artificial Intelligence -------");
		System.out.println("------------Enrique Belenguer 40406742------------");
		
		String[] data = lf.readFile(args[0] + ".cav");
		
		numCaverns = wa.numberCavern(data);
		coorX = wa.returnX(data);
		coorY = wa.returnY(data);
		incidentMatrix =wa.createIncidentMatrix(data);
		
		
		System.out.println("- Number of caverns: " + numCaverns );

		//Creating Caverns
		Cavern[] caverns = new Cavern[numCaverns];
		
		for(int x = 0 ; x < numCaverns ; x++) 
		{
			caverns[x] = new Cavern();
			caverns[x].setId((x));
			caverns[x].setCoordenateX(coorX[x]);
			caverns[x].setCoordenateY(coorY[x]);	
		}
		
		
		start = caverns[0];
		goal = caverns[numCaverns-1];
		
		//Adding Neighbours to each Cavern
		for(int x = 0 ; x < numCaverns ; x++) {
			for(int y = 0; y < numCaverns ; y++) 
				if(incidentMatrix[y][x] == 1)
					caverns[x].addCavern(caverns[y]);
		}		

		path = aStart.aStarSearch(start, goal);
		
		//Creating file
		PrintWriter writer = new PrintWriter(args[0]+".csn", "UTF-8");
		if(path == null)
		{
			writer.print("No path");
			System.out.println("- No path");
		}
		else
		{
			CavernComparer compare = new CavernComparer();
			double path_lengh= 0;
			
			//Inverting the Array
			Collections.reverse(path);
			System.out.printf("- Returning Path: ");
			for(int x = 0 ; x < path.size(); x++)
			{
				System.out.printf(path.get(x).getId()+1+" ");
				arrayPath[x] = path.get(x).getId();
				writer.print(path.get(x).getId()+1+" ");
			}
				
			for(int x = 0; x < path.size() -1; x++)
				path_lengh = path_lengh + compare.getDistance(caverns[path.get(x).getId()],caverns[path.get(x+1).getId()]);
				
			path_lengh = workingArray.round(path_lengh, 2);
			System.out.println("\n- Path Lengh:" + path_lengh);				
		}
		writer.close();

	}

}

