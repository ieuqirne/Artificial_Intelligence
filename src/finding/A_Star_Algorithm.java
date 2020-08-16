package finding;

import finding.Cavern;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class A_Star_Algorithm {

	public ArrayList<Cavern> reconstruct_path(Map<Cavern, Cavern> cameFrom, Cavern current) {
		ArrayList<Cavern> total_path = new ArrayList<Cavern>();
		total_path.add(current);

		while (cameFrom.containsKey(current)) {
			current = cameFrom.get(current);
			total_path.add(current);
		}
		return total_path;
	}

	public List<Cavern> aStarSearch(Cavern start, Cavern goal) {
		CavernComparer compare = new CavernComparer();

		// The set of nodes already evaluated

		List<Cavern> closedSet = new ArrayList<>();

		// The set of currently discovered nodes that are not evaluated yet.
		// Initially, only the start node is known.
		List<Cavern> openSet = new ArrayList<>();

		// Setting up Goal And Start

		// Adding Start Cave
		openSet.add(start);
		// For each node, which node it can most efficiently be reached from.
		// If a node can be reached from many nodes, cameFrom will eventually contain
		// the
		// most efficient previous step.
		HashMap<Cavern, Cavern> cameFrom = new HashMap<Cavern, Cavern>();

		// For each node, the cost of getting from the start node to that node.
		HashMap<Cavern, Double> gScore = new HashMap<Cavern, Double>();

		// The cost of going from start to start is zero.
		gScore.put(start, (double) 0);

		// For each node, the total cost of getting from the start node to the goal
		// by passing by that node. That value is partly known, partly heuristic.
		HashMap<Cavern, Double> fScore = new HashMap<Cavern, Double>();

		// For the first node, that value is completely heuristic
		fScore.put(start, start.getHeurastic(goal));

		// Declare neighbour cavern linked
		List<Cavern> neighbourLinked = new ArrayList<>();
		double tentative_gScore;
		Cavern currentNode;

		while (!openSet.isEmpty()) {
			
			openSet = compare.shortList(openSet, fScore);
			

			currentNode = openSet.get(0);


			// If it has found the goal
			if (currentNode.equals(goal))
				return reconstruct_path(cameFrom, currentNode);

			// Remove 0 because It is actually CurrentNode
			openSet.remove(currentNode);
			closedSet.add(currentNode);

			neighbourLinked = currentNode.getCavernsLinked();

			// for each neighbour of current
			for (int x = 0; x < neighbourLinked.size(); x++) {
				Cavern neigbour = neighbourLinked.get(x);
				
				if (closedSet.contains(neigbour))
					continue;

				tentative_gScore = gScore.get(currentNode) + currentNode.getEuclidean(neigbour);

				if (!openSet.contains(neigbour))
					openSet.add(neigbour);
				else if (tentative_gScore >= gScore.get(neigbour)) // This is not a better path.
					continue;

				cameFrom.put(neigbour, currentNode);
				gScore.put(neigbour, tentative_gScore);
				//fScore.put(neigbour, gScore.get(neigbour) + neigbour.getHeurastic(goal)); //In case I want to implement A*
				fScore.put(neigbour, gScore.get(neigbour) + 0);

			}
		}
		return null;
	}

}
