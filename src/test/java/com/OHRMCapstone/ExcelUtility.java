package com.OHRMCapstone;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ExcelUtility {
	public  FileInputStream fi;
	public  FileOutputStream fo;
	public  XSSFWorkbook wb;
	public  XSSFSheet ws; 
	public  XSSFCell cell;
	public  XSSFRow row;
	String path = null;
	
	ExcelUtility(String path){
		this.path = path;
	}
	
	
	// All the methods related to excel
	
	public  int getRowCount(String xlsheet) throws IOException
	{
	fi= new FileInputStream(path);
	wb= new XSSFWorkbook(fi);
	ws = wb.getSheet(xlsheet);
	int rowcount = ws.getLastRowNum();
	wb.close();
	fi.close();
	return rowcount;
	
	}
	public  int  getCellCount (String xlsheet , int rownum) throws IOException {
		
		fi= new FileInputStream(path);
		wb= new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		int cellCount = row.getPhysicalNumberOfCells();
		wb.close();
		fi.close();
		return cellCount;
		
	}
	
	public String getCellData (String xlsheet , int rownum,int cellCount) throws IOException {
		
		fi= new FileInputStream(path);
		wb= new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		cell=row.getCell(cellCount);
		String data=cell.toString();
		wb.close();
		fi.close();
		return data;
	
	}
	public  void setCellData(String xlsheet , int rownum,int cellCount,String data) throws IOException {
		fi= new FileInputStream(path);
		wb= new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		cell=row.getCell(cellCount);
		cell.setCellValue(data);
		fo= new FileOutputStream(path);
		wb.write(fo);
		wb.close();
		fi.close();fo.close();
		
	}
	public static void getScreenshot(WebDriver driver,String name) throws InterruptedException
	{
		Thread.sleep(3000);
		TakesScreenshot ts=(TakesScreenshot) driver;
	File temp=ts.getScreenshotAs(OutputType.FILE);
	File dest=new File(System.getProperty("user.dir")+"//Screenshot"+name+System.currentTimeMillis()+".png");
	try {
		FileHandler.copy(temp,dest);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}
	
	
	

}
