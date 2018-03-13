import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DistanceFlowMatrix implements DistanceFlowMatrixI {
    private int size;
    private int distanceMatrix[][];
    private int flowMatrix[][];

    DistanceFlowMatrix(String path){
        //Load File to String
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String allFile= "";
            String sCurrentLine;
            int a =2;
            while ((sCurrentLine = br.readLine()) != null) {
                allFile +=sCurrentLine;
            }
            // Convert String And Make Matrix
            allFile = allFile.replaceAll("\\D+"," ");
            size = Integer.parseInt(allFile.split(" ")[1]);
            flowMatrix = new int[size][size];
            distanceMatrix = new int[size][size];
            while(a < size*size){
                for (int j = 0; j < size; j++) {
                    for (int i = 0; i < size; i++) {
                        flowMatrix[i][j] = Integer.parseInt(allFile.split(" ")[a]);
                        distanceMatrix[i][j] = Integer.parseInt(allFile.split(" ")[a+size*size]);
                        a= a+1;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getSize() {
        return size;
    }

    public int getDistanceBetween(int i ,int j){
        return distanceMatrix[i-1][j-1];

    }

    public int getFlowBetween(int i, int j){
        return flowMatrix[i][j];
    }
}
