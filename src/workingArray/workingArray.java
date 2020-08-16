package workingArray;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class workingArray {

	private int numCavern; 
		
	public int numberCavern(String[] data) {
		
		this.numCavern = Integer.parseInt(data[0]);
		
		return numCavern;
	}
	
	public int[]returnDataInt(String[] data) {
		int[] dataInt;
		dataInt = new int[data.length];
		
		for(int x = 0; x < data.length; x++)
		{
			dataInt[x] = Integer.parseInt(data[x]);
		}
		
		return dataInt;
	}
	
	public int[] returnX(String[] data) {
		int[] coorX;
		coorX = new int[Integer.parseInt(data[0])];
		
		for(int x= 0; x < coorX.length; x++)
		{
			coorX[x] = Integer.parseInt(data[1+(2*x)]);

		}
		return coorX;
	}
	
	public int[] returnY(String[] data) {
		int[] coorY;
		coorY = new int[Integer.parseInt(data[0])];
		
		for(int x= 0; x < coorY.length; x++)
		{
			coorY[x] = Integer.parseInt(data[2+(2*x)]);

		}
		return coorY;
	}
	public int[][] createIncidentMatrix(String[] data) {

		int[][] twoDim;
		twoDim = new int[this.numCavern][this.numCavern];
		
		for(int x= 0; x < this.numCavern ; x++)
		for(int y = 0; y < this.numCavern ; y++)
		{
			//caverns[x].addCavern(y);
			twoDim[x][y]= Integer.parseInt(data[(1+(this.numCavern * 2) + (x * this.numCavern) + y)]);
		}
		return twoDim;
	}
	
	public int[] returnLastCave(int[] coorX,int[] coorY, int numCavern) {	
		int [] lastCave = new int[2];
		
			lastCave[0] = coorX[numCavern-1];
			lastCave[1] = coorY[numCavern-1];
		
		return lastCave;		
	}
	
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();
	 
	    BigDecimal bd = new BigDecimal(Double.toString(value));
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}

}
