package loadingData;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class loadingFile {
	
	private BufferedReader br;

	public String[] getName(String fileNamePath) throws Exception {
        String[] data = null;

		 while (fileNamePath != null) {
			 data = fileNamePath.split("\\.");
		       }
		      
		return data;	
	}
	
	public String[] readFile(String fileNamePath) throws Exception {
        try {
        	String[] data = null;
    		String value = null;
			br = new BufferedReader(new FileReader(fileNamePath));
			
			 while ((value = br.readLine()) != null) {
				 data = value.split(",");
			       }
			      
			return data;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}	
	}
	
	public int[] convertInteger(String[] data) {
		int[] dataInt;
		dataInt = new int[data.length];
		
		for(int x= 0; x < data.length; x++)
		{
			dataInt[x] = Integer.parseInt(data[x]);
		}
		return dataInt;
	}
	

	
	public int[][] createTwoDimens(String[] data) {
		int[][] twoDim;
		twoDim = new int[Integer.parseInt(data[0])][2];
		
		for(int x= 0; x < Integer.parseInt(data[0]); x++)
		{
				twoDim[x][0] = Integer.parseInt(data[1+(2*x)]);
				twoDim[x][1] = Integer.parseInt(data[2+(2*x)]);
		}
		return twoDim;
	}
		

	
}
