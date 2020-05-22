package testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingFromExcel {
	
	public ArrayList<String> getData(String testCaseName) throws IOException{
		ArrayList<String> a=new ArrayList<String>(); 
		FileInputStream fis=new FileInputStream("E:\\Selenium\\testdata.xlsx");
		//Suppose our test data is in the sheet names "TestData"
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		int numberOfSheets=wb.getNumberOfSheets();
		for (int i=0;i<numberOfSheets;i++) {
			if(wb.getSheetName(i).equalsIgnoreCase("TestData")) {
				XSSFSheet sheet=wb.getSheetAt(i);
				Iterator<Row> rows=sheet.iterator();
				Row firstRow=rows.next();
				Iterator<Cell> cell=firstRow.cellIterator();
				int k=0,column=0;
				while(cell.hasNext()) {
					Cell value=cell.next();
					if(value.getStringCellValue().equalsIgnoreCase("TestCases")) {
						//Grab desired column	
						column=k;
					}
					k++;
				}
				while(rows.hasNext()) {
					Row r=rows.next();
					if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testCaseName)) {
						Iterator<Cell> cv=r.cellIterator();
						while(cv.hasNext()) {
							//System.out.println(cv.next().getStringCellValue());
							//a.add(cv.next().getStringCellValue());
							Cell c=cv.next();
							if(c.getCellTypeEnum()==CellType.STRING) {
								a.add(c.getStringCellValue());
							}else {
								a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
							}		
						}
					}
					//Iterator<Cell> cv=r.cellIterator();
				}
			}
		}
		return a;
	}
}