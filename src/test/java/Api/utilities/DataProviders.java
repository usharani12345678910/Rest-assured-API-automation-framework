package Api.utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {
	@DataProvider(name="AllData")
	public String [][] AllDataProvider()
	{
		String fName = System.getProperty("user.dir")+"//TestData//TestData.xlsx";
		
		int ttlRowCnt = ReadExcelFile.getRowCount(fName, "Sheet1");
		int ttlColCnt= ReadExcelFile.getColCount(fName, "Sheet1");
		
		String userData[][] = new String[ttlRowCnt-1][ttlColCnt];
		
		for(int i= 1; i<ttlRowCnt; i++)
		{
			for(int j=0; j<ttlColCnt; j++)
			{
				userData[i-1][j] = ReadExcelFile.getCellValue(fName, "Sheet1", i, j);
			}
			
		}
		return userData;
	}
	
	
	@DataProvider(name="UserNamesData")
	public String [] UserNamesDataProvider()
	{
		String fName = System.getProperty("user.dir")+"//TestData//TestData.xlsx";
		
		int ttlRowCnt = ReadExcelFile.getRowCount(fName, "Sheet1");
	//	int ttlColCnt= ReadExcelFile.getColCount(fName, "Sheet1");
		
		String userNamesData[] = new String[ttlRowCnt-1];
		
		for(int i = 1; i<ttlRowCnt; i++)
		{
			userNamesData[i-1] = ReadExcelFile.getCellValue(fName, "Sheet1", i, 1);
			
		}
		return userNamesData;
	}
	
	
}