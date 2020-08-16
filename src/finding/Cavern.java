package finding;


import java.util.ArrayList;

public class Cavern{
	private int id;
	private int coordenateX;
	private int coordenateY;
	private ArrayList<Cavern> cavernsLinked;

	public Cavern()
	{
		cavernsLinked = new ArrayList<Cavern>();
	}
	public int getCoordenateX() {
		return coordenateX;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setCoordenateX(int coordenateX) {
		this.coordenateX = coordenateX;
	}
	public int getCoordenateY() {
		return coordenateY;
	}
	public void setCoordenateY(int coordenateY) {
		this.coordenateY = coordenateY;
	}
	
	public void addCavern(Cavern c) {
		cavernsLinked.add(c);
	}
	
	public Cavern getCaver(int i) {
		return cavernsLinked.get(i);
	}
		
	public int getCavernsLinkedSize() {
		return this.cavernsLinked.size();
	}
	public ArrayList<Cavern> getCavernsLinked() {
		return this.cavernsLinked;
	}

	public double getHeurastic(Cavern goal){
		return (Math.abs(this.coordenateX - goal.coordenateX) + Math.abs(this.coordenateY - goal.coordenateY));
	}
	public double getEuclidean(Cavern x){
		return (Math.sqrt(Math.pow(x.coordenateX - this.coordenateX, 2) + Math.pow(x.coordenateY - this.coordenateY, 2)));
	}
	public int getId() {
		return this.id;
	}

}
