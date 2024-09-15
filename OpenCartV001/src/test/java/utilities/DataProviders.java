package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
		String filePath = ".\\testData\\DDT test cases.xlsx";
	    String sheetName = "Sheet1";
	    ExcelUtility excel = new ExcelUtility(filePath, sheetName);
	    
	    int totalRows = excel.getRowCount();
	    int totalCols = excel.getColumnCount(1);
	    
	    String loginData[][] = new String[totalRows-1][totalCols];
	    System.out.println("Rows : " + totalRows + ", Cols : " + totalCols);
	    
	    for(int i=1;i<totalRows;i++)
	    {
	    	for(int j=0;j<totalCols;j++)
	    	{
	    		loginData[i-1][j] = excel.getCellData(i, j);
	    		System.out.println("Row : " + i + " , Col : " + j + " : " + loginData[i-1][j]);
	    	}
	    }
	    
	    excel.closeExcel();

	    return loginData;

	    
	}
	
}
