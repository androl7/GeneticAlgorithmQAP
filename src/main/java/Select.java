import java.util.*;

public class Select {
    private Random randomGenerator = new Random();
    private Population population;

    Select(Population population){
        this.population = population;

    }
    // Select Individual with tournament method
    public Individual tournament(int howMuchIndividuals){
        ArrayList<Individual> tournamentArray = new ArrayList<Individual>();
        for(int i=0;i<howMuchIndividuals;i++){
            tournamentArray.add(population.getIndividual(randomGenerator.nextInt(population.getPopulationSize())));
        }
        Individual best = Collections.min(tournamentArray, (Comparator<Individual>) (o1, o2) -> o1.getAssignmentCost()-o2.getAssignmentCost());
        return best;
    }
}
