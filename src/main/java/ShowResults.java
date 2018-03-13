import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;

class ShowResults {
    private Individual best;
    private Individual weakest;
    private int average;
    private Workbook workbook;
    private Sheet sheet;
    ShowResults(){
        this.workbook= new XSSFWorkbook();
        String[] columns = new String[]{"Best", "Average", "Weakest"};
        this.sheet = workbook.createSheet("Results");
        // Create a Font for styling header cells
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.RED.getIndex());

        // Create a CellStyle with the font
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

        // Create a Row
        Row headerRow = sheet.createRow(0);

        // Creating cells
        for(int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);
        }
        // Resize all columns to fit the content size
        for(int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }
    }
    public void inConsole(Population population){
        this.best =  Collections.min(population.getPopulation(), (Comparator<Individual>) (o1, o2) -> o1.getAssignmentCost()-o2.getAssignmentCost());
        this.weakest = Collections.min(population.getPopulation(), (Comparator<Individual>) (o1, o2) -> o2.getAssignmentCost()-o1.getAssignmentCost());

        double averageD = 0;
        for(int i=0;i<population.getPopulation().size();i++){
            averageD += population.getPopulation().get(i).getAssignmentCost();
        }
        averageD = averageD/(double)population.getPopulation().size();
        this.average = (int) averageD;

        String result = "<Best: "+best.getAssignmentCost()+"; Average: "+average+"; Weakest: "+ weakest.getAssignmentCost()+">";
        System.out.println(result);
    }

    public void writeToExel(int rowNum,Population population) throws IOException {
        this.best =  Collections.min(population.getPopulation(), (Comparator<Individual>) (o1, o2) -> o1.getAssignmentCost()-o2.getAssignmentCost());
        this.weakest = Collections.min(population.getPopulation(), (Comparator<Individual>) (o1, o2) -> o2.getAssignmentCost()-o1.getAssignmentCost());

        double averageD = 0;
        for(int i=0;i<population.getPopulation().size();i++){
            averageD += population.getPopulation().get(i).getAssignmentCost();
        }
        averageD = averageD/(double)population.getPopulation().size();
        this.average = (int) averageD;

        Row row = sheet.createRow(rowNum);
        // Create Other rows and cells with data
        row.createCell(0).setCellValue(best.getAssignmentCost());
        row.createCell(1).setCellValue(average);
        row.createCell(2).setCellValue(weakest.getAssignmentCost());

        FileOutputStream fileOut = new FileOutputStream("C:\\Users\\ROG\\Desktop\\Praca\\JavaProjects\\SI1QAP\\EXEL\\data.xlsx");
        workbook.write(fileOut);
        fileOut.close();

    }



}
