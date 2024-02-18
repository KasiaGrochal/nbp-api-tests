package models;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Table {
    private String table;
    private String no;
    private String effectiveDate;
    private ArrayList<Rate> rates;
}
