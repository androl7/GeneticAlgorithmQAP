import java.util.ArrayList;
import java.util.Random;

class Individual implements IndividualI {
    private ArrayList<Integer> locations;
    private int assignmentCost =-1;

    Individual(int howManyLocations){
        locations = new ArrayList<>();
        if(howManyLocations>-1) {
            do {
                Random generator = new Random();
                int location = generator.nextInt(howManyLocations) + 1;
                if (!locations.contains(location)) {
                    locations.add(location);
                }
            } while (locations.size() < howManyLocations);
        }
    }

    public int getValueOfLocation(int position){
        return locations.get(position);
    }

    public int getAssignmentCost() {
        return assignmentCost;
    }

    public void setAssignmentCost(int assignmentCost) {
        this.assignmentCost = assignmentCost;
    }

    public ArrayList<Integer> getLocationsArray() {
        return locations;
    }
}
