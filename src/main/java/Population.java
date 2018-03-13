import java.util.ArrayList;

class Population implements PopulationI {

    private ArrayList<Individual> population;

    Population(){
        population = new ArrayList<>();
    }

    public ArrayList<Individual> getPopulation() {
        return population;
    }

    public Individual getIndividual(int index){
        return population.get(index);
    }

    public void setIndividualToPopulation(int i,Individual inv){
        population.set(i,inv);
    }

    public void initialisePopulation(int populationSize,DistanceFlowMatrix dfm){
        for(int i=0;i<populationSize;i++){
            population.add(new Individual(dfm.getSize()));
        }
    }

    public int getPopulationSize(){
        return population.size();
    }

}
