package finding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class CavernComparer {

	public double getDistance(Cavern x, Cavern y){
		return (Math.sqrt(Math.pow(y.getCoordenateX() - x.getCoordenateX(), 2) + Math.pow(y.getCoordenateY() - x.getCoordenateY(), 2)));
	}
	
	public List<Cavern> shortList(List<Cavern> open, HashMap<Cavern,Double> fScore){
		List<Cavern> temp = new  ArrayList<>();
		temp = open;
		
		Collections.sort(temp,new Comparator<Cavern>()
		{
			@Override
			public int compare(Cavern c1, Cavern c2) {
				return Double.compare(fScore.get(c1),fScore.get(c2));
			}
			
			
		});
		return temp;
	}
	

}
