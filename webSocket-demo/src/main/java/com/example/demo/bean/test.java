package com.example.demo.bean;

import com.example.demo.utils.ExcelCell;

public class test {
    @ExcelCell(col = 0)
    private Integer q_id;
    @ExcelCell(col = 1)
    private String q_name;
    @ExcelCell(col = 2)
    private Object q_value;
}
