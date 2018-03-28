package com.situ.crm.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

public class POITest {
	
	@Test
	public void testWrite03Excel() throws Exception{
		//1.创建工作薄
		HSSFWorkbook workbook = new HSSFWorkbook();
		//2.创建工作表：sheet
		HSSFSheet sheet = workbook.createSheet("Hello POI");
		//3.创建行row
		HSSFRow row = sheet.createRow(2);
		//4.创建单元格
		HSSFCell cell = row.createCell(2);
		cell.setCellValue("Hello POI!");
		FileOutputStream outputStream = new FileOutputStream("D:\\poitest\\poi.xls");
		workbook.write(outputStream);
		workbook.close();
		outputStream.close();
		
		
	}
	@Test
	public void testWrite07Excel() throws Exception{
		//1.创建工作薄
		XSSFWorkbook workbook = new XSSFWorkbook();
		//2.创建工作表：sheet
		XSSFSheet sheet = workbook.createSheet("Hello POI");
		//3.创建行row
		XSSFRow row = sheet.createRow(2);
		//4.创建单元格
		XSSFCell cell = row.createCell(2);
		cell.setCellValue("123456!");
		FileOutputStream outputStream = new FileOutputStream("D:\\poitest\\poi.xlsX");
		workbook.write(outputStream);
		workbook.close();
		outputStream.close();
		
		
	}
	@Test
	public void testRead03ExcelStyle() throws Exception{
		FileInputStream inputStream = new FileInputStream("D:\\poitest\\poi.xls");
		//1.读取工作薄：workbook
		HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
		//2.读取工作表：sheet
		HSSFSheet sheet = workbook.getSheetAt(0);
		//3.读取行：Row
		HSSFRow row = sheet.getRow(2);
		//4.读取单元格
		HSSFCell cell = row.getCell(2);
		String Value = cell.getStringCellValue();
		System.out.println(Value);
		workbook.close();
		inputStream.close();
	}
	
    @Test
    public void testRead03Excel() throws Exception{
    	//1.创建工作薄：workbook
    	HSSFWorkbook workbook = new HSSFWorkbook();
    	//2.创建工作表：sheet
    	HSSFSheet sheet = workbook.createSheet("用户列表");
    	//设置默认的列宽
    	sheet.setDefaultColumnWidth(25);
    	//2.1创建合并单元对象
    	CellRangeAddress cellRangeAddress = new CellRangeAddress(2, 6, 1, 12);
    	sheet.addMergedRegion(cellRangeAddress);
    	//3.创建行：Row
    	HSSFRow row = sheet.createRow(2);
    	//4.创建单元格：cell
    	HSSFCell cell = row.createCell(1);
    	
    	HSSFCellStyle style = createStyle(workbook,25);
    	cell.setCellStyle(style);
    	cell.setCellValue("用户列表");
    	
    	HSSFRow rowHead = sheet.createRow(7);
    	//创建单元格
    	String[] array = {"编号","客户名称","概要","联系人"};
    	for(int i = 0;i<array.length;i++){
    		HSSFCell cellHead = rowHead.createCell(i+1);
    		HSSFCellStyle headStyle = createStyle(workbook, 13);
    		cell.setCellStyle(headStyle);
    		cellHead.setCellValue(array[i]);
    	}
    	FileOutputStream outputStream = new FileOutputStream("D:\\poitest\\poi.xls");
    	//输出excel到文件
        workbook.write(outputStream);
        
    	
    }
    private HSSFCellStyle createStyle(HSSFWorkbook workbook,int fontSize){
    	//创建单元格样式
    	HSSFCellStyle style = workbook.createCellStyle();
    	style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
    	style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
    	//创建字体
    	HSSFFont font = workbook.createFont();
    	font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//字体加粗
    	font.setFontHeightInPoints((short)fontSize);
    	//加载字体到样式
    	style.setFont(font);
    	return style;
    }
}
