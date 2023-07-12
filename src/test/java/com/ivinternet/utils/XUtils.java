package com.ivinternet.utils;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class XUtils {
    static FileInputStream fi;
    static FileOutputStream fo;
    static XSSFWorkbook wb;
    static XSSFSheet sheet;
    static XSSFRow row;
    static XSSFCell cell;

    private static XSSFSheet getWorkbookSheet(String xmlFile, String sheetName) throws IOException {

        try {
            fi = new FileInputStream(xmlFile);
            wb = new XSSFWorkbook();
            sheet = wb.getSheet(sheetName);
            return sheet;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static int getRowCount(String xmlFile, String sheetName) throws IOException {
        try{
            XSSFSheet sheet1 = getWorkbookSheet(xmlFile, sheetName);
            return sheet1.getLastRowNum();

        }finally {
            wb.close();
            fi.close();

        }
    }

    public static int getCellCount(String xmlFile, String sheetName,int rowNum) throws IOException {
        try{
            XSSFSheet sheet1 = getWorkbookSheet(xmlFile, sheetName);
            XSSFRow row = sheet1.getRow(rowNum);
            return row.getLastCellNum();

        }finally {
            wb.close();
            fi.close();

        }
    }

    public static int getCellData(String xmlFile, String sheetName,int rowNum) throws IOException {
        try{
            XSSFSheet sheet1 = getWorkbookSheet(xmlFile, sheetName);
            XSSFRow row = sheet1.getRow(rowNum);
            return row.getLastCellNum();

        }finally {
            wb.close();
            fi.close();

        }
    }
}
