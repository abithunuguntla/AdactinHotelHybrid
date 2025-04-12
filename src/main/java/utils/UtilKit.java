package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UtilKit{
	public static FileInputStream file;
	
	public static HashMap<String, String> testdata(String Tcnumber){
	 try {
		file = new FileInputStream("D:\\Abhishek Workspace\\AdactinHotelTestCases\\src\\test\\resources\\excels\\excelataadactin.xlsx");
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	 
	 XSSFWorkbook wb = null;
		try {
			 wb = new XSSFWorkbook(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	XSSFSheet ws= wb.getSheet("Sheet1");
	DataFormatter formatter = new DataFormatter();
	ArrayList<Row> testrows = gettestrows(Tcnumber, ws);
	HashMap<String, String> testDataMap=new HashMap<String, String>();
	
	for(int i=0;i<testrows.size()-1;i++) {
		int nofofcells = testrows.get(i).getLastCellNum();
		for(int j=1; j<nofofcells;j++) {
			String key = formatter.formatCellValue(testrows.get(0).getCell(j));
			String value = formatter.formatCellValue(testrows.get(1).getCell(j));
		testDataMap.put(key, value);
		}
		
	}	
	return testDataMap;
	}
	
	private static ArrayList<Row> gettestrows(String Tcnumber , XSSFSheet ws){
		ArrayList<Row> allrows = new ArrayList();
		for(int i =0; i<=ws.getLastRowNum();i++) {
			if(ws.getRow(i)!=null)
			{
			 allrows.add(ws.getRow(i));
				
			}
		}
		ArrayList<Row> testcaseRow = new ArrayList();
		for(int i =0;i<allrows.size();i++) {
			if(allrows.get(i).getCell(0).getStringCellValue().equalsIgnoreCase(Tcnumber)) {
				testcaseRow.add(allrows.get(i));
			}
		}
		return testcaseRow;
	}
	
	

	
	
	
	
	
}