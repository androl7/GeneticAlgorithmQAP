import java.util.Collections;
import java.util.Random;

class Mutation {
    // Change gens with with different gen
    //considering the probability
    Mutation(Individual inv,double probability){
        Random generator = new Random();
        for(int i = 0;i<inv.getLocationsArray().size();i++){
            if(Math.random() < probability){
                int swap = generator.nextInt(inv.getLocationsArray().size());
                Collections.swap(inv.getLocationsArray(),i,swap);
            }
        }
    }
}
