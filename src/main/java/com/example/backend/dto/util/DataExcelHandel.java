package com.example.backend.dto.util;

import java.util.LinkedHashMap;

public class DataExcelHandel {
    private LinkedHashMap<String, Object> data = new LinkedHashMap<String, Object>();
    
    public DataExcelHandel(String [] column ) {
        for(int i=0;i<column.length;i++) {
            data.put(column[i], null);
        }
    }
    public LinkedHashMap<String, Object> getData() {
        return data;
    }
    
    public  void setDataToKey(String key , Object setData) {
        this.data.put(key, setData);
    }
    
    public  Object getDataToKey(String key) {
        return this.data.get(key);
    }

}
