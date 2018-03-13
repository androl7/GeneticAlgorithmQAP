import java.io.IOException;

class QAP {
    QAP(String file, int popSize, int howMuchGen, double Px, double Pm,int tour) throws IOException {
        System.err.close();
        System.setErr(System.out);

        //creating a path to the file
        String path = "C:\\Users/ROG/Desktop/Praca/JavaProjects/SI1QAP/"+file;
        //creating Matrix from file
        DistanceFlowMatrix dfm = new DistanceFlowMatrix(path);

        // Initialise populations
        Population population = new Population();
        Population newPopulation = new Population();
        newPopulation.initialisePopulation(popSize,dfm);
        population.initialisePopulation(popSize,dfm);

        //calculated the cost of the all individuals in population
        for(int i =0;i<population.getPopulationSize();i++){
            new Evaluate(population.getIndividual(i),dfm);
        }

        // show results in console and write to xlsx file
        ShowResults sr =new ShowResults();
        System.out.print("1. ");
        sr.inConsole(population);
        sr.writeToExel(1,population);

        //start Genetic loop
        int loop=0;
        while(loop<howMuchGen-1) {
            for (int i = 0; i < population.getPopulationSize(); i++) {
                //Select 2 individuals
                Individual inv1 = new Select(population).tournament(tour);
                Individual inv2 = new Select(population).tournament(tour);

                //Crossing two individuals
                Individual invCross = new Crossover(inv1, inv2, Px).crossover();

                // Mutation
                new Mutation(invCross, Pm);

                //calculated the cost of the individual
                new Evaluate(invCross, dfm);

                //add individual to new population
                newPopulation.setIndividualToPopulation(i, invCross);
            }
            System.out.print(loop+2+". ");
            sr.inConsole(population);
            sr.writeToExel(loop+2,population);
            population = newPopulation;
            loop++;
        }
    }
}
