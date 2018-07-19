package com.company;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExcelReader {
    private static final String FILE_NAME = "C:\\Users\\vprasan\\Desktop\\eBay\\Example TDR.xlsx";

    public static void main(String[] args) {

        try {
            FileInputStream file = new FileInputStream(new File(FILE_NAME));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);

            Iterator<Row> rowIterator = sheet.iterator();

            int rows;
            rows = sheet.getPhysicalNumberOfRows();
            System.out.println("Total Rows:" + rows);

            int cols;
            cols = sheet.getRow(1).getPhysicalNumberOfCells();
            System.out.println("Total Columns:" + cols);

            int count = 0;
            if(rowIterator.hasNext())rowIterator.next(); //Excluding the header

            while (rowIterator.hasNext())
            {
                count++;

                if(count > 10) break; //Reading only 10 rows.
                Row row = rowIterator.next();

                //For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();
                Date javaDate = null;

                while (cellIterator.hasNext())
                {
                    Cell cell = cellIterator.next();

                    int colIndex=cell.getColumnIndex();
                    switch(colIndex) {
                        case 1:{
                            javaDate= DateUtil.getJavaDate(cell.getNumericCellValue());
                            System.out.print(new SimpleDateFormat("MM/dd/yyyy").format(javaDate) + "\t");
                        } break;
                        case 3:{
                            System.out.print(cell.getNumericCellValue() + "\t");
                        } break;
                        case 10:{
                            System.out.print(cell.getStringCellValue() + "\t");
                        } break;
                        case 12:{
                            cell.setCellType(Cell.CELL_TYPE_STRING);
                            System.out.print(cell.getStringCellValue() + "\t");
                        } break;
                        case 20:{
                            System.out.print(cell.getNumericCellValue() + "\t");
                        } break;
                        default :{continue;}
                    }
                    /*if (cell.getCellTypeEnum() == CellType.STRING) {
                        System.out.print(colIndex + "s\t");
                        System.out.print(cell.getStringCellValue() + "\t");
                    } else if (cell.getCellTypeEnum() == CellType.NUMERIC) {
                        System.out.print(colIndex + "n\t");
                        System.out.print(cell.getNumericCellValue() + "\t");
                    }*/
                }
                System.out.println("");
            }
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
