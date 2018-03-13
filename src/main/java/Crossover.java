import java.util.*;

public class Crossover {
    private Individual inv1;
    private Individual inv2;
    private double probability;
    Crossover(Individual inv1,Individual inv2,double probability){
        this.inv1=inv1;
        this.inv2=inv2;
        this.probability=probability;
    }

    public Individual crossover(){

        if(Math.random() < probability) {
            Individual child = new Individual(-1);
            Random randomGenerator = new Random();
            int splitValue = randomGenerator.nextInt(inv1.getLocationsArray().size());
            //add part of first parent
            for (int i = 0; i < splitValue; i++) {
                child.getLocationsArray().add(i, inv1.getLocationsArray().get(i));
            }
            //add second part of second parent
            for (int i = splitValue; i < inv1.getLocationsArray().size(); i++) {
                    child.getLocationsArray().add(i, inv2.getLocationsArray().get(i));
            }
            //delete repeat
            Set<Integer> childSet = new LinkedHashSet<>(child.getLocationsArray());
            //add to Set missing genes
            for(int i=1; i<child.getLocationsArray().size()+1;i++){
                childSet.add(i);
            }
            child.getLocationsArray().clear();
            child.getLocationsArray().addAll(childSet);
            return child;
        }else{
            inv1.setAssignmentCost(-1);
            return inv1;
        }

    }
}
