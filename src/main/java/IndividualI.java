import java.util.ArrayList;

public interface IndividualI {
    int getValueOfLocation(int position);
    int getAssignmentCost();
    void setAssignmentCost(int assignmentCost);
    ArrayList<Integer> getLocationsArray();
}
