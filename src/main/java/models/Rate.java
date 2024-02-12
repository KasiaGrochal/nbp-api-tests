package models;

import lombok.Data;


@Data
public class Rate {
    private String currency;
    private String code;
    private double mid;

}
