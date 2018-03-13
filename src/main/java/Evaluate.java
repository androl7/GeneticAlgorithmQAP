class Evaluate {
// calculated the cost of the individual's assignment
    Evaluate(Individual individual, DistanceFlowMatrix dfm){
        if(individual.getAssignmentCost()==-1){
            int summaryPath = 0;
            for(int i=0; i<dfm.getSize();i++){
                for(int j=0;j<dfm.getSize();j++){
                    summaryPath += dfm.getDistanceBetween(individual.getValueOfLocation(i),individual.getValueOfLocation(j))*dfm.getFlowBetween(i,j);
                }
            }
            individual.setAssignmentCost(summaryPath);
        }
    }
}
