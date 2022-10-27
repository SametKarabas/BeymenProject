package Utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ExcelUtils {


    public static ArrayList<ArrayList<String>> getListData(String path, String sheetName, int columnCount){
        ArrayList<ArrayList<String>> tablo=new ArrayList<>();


        Workbook workbook=null;
        try {
            FileInputStream inputStream = new FileInputStream(path);
            workbook= WorkbookFactory.create(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Sheet sayfa=workbook.getSheet(sheetName);

        for (int i = 0; i < sayfa.getPhysicalNumberOfRows(); i++) {

            ArrayList<String>  satirData=new ArrayList<>();
            for (int j = 0; j < columnCount; j++) {
                satirData.add(sayfa.getRow(i).getCell(j).toString());
            }

            tablo.add(satirData);
        }
        return tablo;
    }
}
