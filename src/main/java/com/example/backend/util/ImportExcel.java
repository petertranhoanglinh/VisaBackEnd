package com.example.backend.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import com.example.backend.dto.util.DataExcelHandel;
import com.example.backend.dto.util.ImportExcelDto;

@Component
public class ImportExcel<T> {
    public List<LinkedHashMap<String, Object>>  getExceltoListData(ImportExcelDto excel, String [] column) throws Exception{
        String excelFile = excel.getFileData().getOriginalFilename().toString();
        List<LinkedHashMap<String, Object>> listdata  = new ArrayList<>();
        
        if(!excel.getFileData().isEmpty()) {
            Workbook workbook = getWorkbook(excel.getFileData().getInputStream(), excelFile);
            Sheet sheet = workbook.getSheetAt(0);
            
            Iterator<Row> rowInterator = sheet.iterator();
            
            rowInterator.next();
            
            while (rowInterator.hasNext()) {
                DataExcelHandel dataexcel = new DataExcelHandel(column);
                Row row = rowInterator.next();
                
                Iterator<Cell> cellIterator = row.cellIterator();
                
                while (cellIterator.hasNext()) {
                    
                    Cell cell = cellIterator.next();
                    
                    CellType cellType = cell.getCellType();
                    
                    cell.setCellType(CellType.STRING);
                    
                    for (int i = 0 ; i<column.length;i++) {
                        
                        if(cell.getColumnIndex() == i) {
                            dataexcel.setDataToKey(column[i], cell.getStringCellValue());
                        }
                    }

                }
                listdata.add(dataexcel.getData());
            }
            workbook.close();
            
            
        }
        return listdata;
    }
    
    
    
    private Workbook getWorkbook(InputStream inputStream, String excelFile) throws IOException {
        Workbook workbook = null;
        
        if (excelFile.endsWith("xlsx")) {
            workbook = new XSSFWorkbook(inputStream);
        } else {
            workbook = new HSSFWorkbook(inputStream);
        }

        return workbook;
    }
    

}
