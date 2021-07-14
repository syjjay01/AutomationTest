package com.libarary.Utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtil {
	
    private static XSSFWorkbook wb;
    private static XSSFSheet userDatasheet;
    private static XSSFSheet testDatasheet;
    private static XSSFSheet writeDatasheet;
    private static XSSFRow row;
    private static String WriteExcelPath = System.getProperty("user.dir") + "\\src\\com\\test\\TestData\\qqmd_WriteData.xlsx";
    
	 /**
      * 读取Excel数据内容
	   * @param InputStream
	   *   * @return Map 包含单元格数据内容的Map对象
	 * @throws IOException 
	 * @throws InvalidFormatException 
     */

    //获取第一个excel sheet中的userID和账号
    public static LinkedHashMap<String, String> readLoginUserData(String ExcelPath, String sheetName) throws IOException{
		   InputStream is = new FileInputStream(ExcelPath);
		   LinkedHashMap<String, String> usersDataMap = new LinkedHashMap<String, String>();	
			wb = new XSSFWorkbook(is);
			userDatasheet = wb.getSheet(sheetName);
	        // 得到总行数
	        int rowNum = userDatasheet.getLastRowNum();
	        // 正文内容应该从第二行开始,第一行为表头的标题
	        for (int i = 1; i <= rowNum; i++) {
	            row = userDatasheet.getRow(i);
	            String userID =  getCellFormatValue(row.getCell((short) 0)).trim();
	            String userName = getCellFormatValue(row.getCell((short) 1)).trim();
	            usersDataMap.put(userID, userName);
	        }
	        return usersDataMap;
	    }
    
    //获取第一个excel sheet中的账号密码
    public static LinkedHashMap<String, String> readLoginUserPassword(String ExcelPath, String sheetName) throws IOException{
		   InputStream is = new FileInputStream(ExcelPath);
		   LinkedHashMap<String, String> userPasswordMap = new LinkedHashMap<String, String>();
			wb = new XSSFWorkbook(is);
			userDatasheet = wb.getSheet(sheetName);
	        // 得到总行数
	        int rowNum = userDatasheet.getLastRowNum();
	        // 正文内容应该从第二行开始,第一行为表头的标题
	        for (int i = 1; i <= rowNum; i++) {
	            row = userDatasheet.getRow(i);
	            String userName = getCellFormatValue(row.getCell((short) 1)).trim();
	            String password = getCellFormatValue(row.getCell((short) 2)).trim();
	            userPasswordMap.put(userName, password);
	        }
	        return userPasswordMap;
	    }
    
    
    
    //获取测试数据
		public static Map<String, String> readTestData(String ExcelPath, String sheetName) throws IOException {
			   InputStream is = new FileInputStream(ExcelPath);
		       Map<String, String> testData = new HashMap<String, String>();	
				wb = new XSSFWorkbook(is);
				testDatasheet = wb.getSheet(sheetName);
//				testDatasheet = wb.getSheetAt(0);
		        // 得到总行数
		        int rowNum = testDatasheet.getLastRowNum();
		        // 正文内容应该从第二行开始,第一行为表头的标题
		        for (int i = 1; i <= rowNum; i++) {
		            row = testDatasheet.getRow(i);
//		            String DataKey= getCellFormatValue(row.getCell((short) 1)).trim();
//		            String DataValue= getCellFormatValue(row.getCell((short) 2)).trim();
		            String DataKey= getCellFormatValue(row.getCell((short) 1));
		            String DataValue= getCellFormatValue(row.getCell((short) 2));
		            testData.put(DataKey, DataValue);  
		        }
		        return testData;
		    }

		

	 private static String getCellFormatValue(XSSFCell cell) {
		    String cellvalue = "";
		    if (cell != null) {
		       cell.setCellType(Cell.CELL_TYPE_STRING);
		       cellvalue = String.valueOf(cell.getStringCellValue());
		        }
		    return cellvalue;

		    }  
	
	 
	//写入内容到excel的第一个sheet，第3列，指定行
	public static void writeExcel(String writeData, int rowNum) throws IOException{
		InputStream is = new FileInputStream(WriteExcelPath);
		wb = new XSSFWorkbook(is);
		writeDatasheet = wb.getSheet("TestData");
		writeDatasheet.getRow(rowNum-1).createCell(2).setCellValue(writeData);
        //保存文件
        OutputStream os = new FileOutputStream(WriteExcelPath);
        //覆盖写入内容
        wb.write(os);
		}		  	

}
	
	

