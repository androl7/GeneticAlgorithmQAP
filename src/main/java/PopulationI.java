import java.util.ArrayList;

public interface PopulationI {
    ArrayList<Individual> getPopulation();
    Individual getIndividual(int index);
    void setIndividualToPopulation(int i,Individual inv);
    void initialisePopulation(int populationSize,DistanceFlowMatrix dfm);
    int getPopulationSize();
}
