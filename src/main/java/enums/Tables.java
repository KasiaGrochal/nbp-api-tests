package enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum Tables {
    TABLE_A("{tables}", "A"),
    TABLE_B("{tables}", "B"),
    TABLE_C("{tables}", "C");

    private final String pathParamName;
    private final String pathParamValue;


    Tables(String pathParamName, String pathParamValue) {
        this.pathParamName = pathParamName;
        this.pathParamValue = pathParamValue;
    }

    public static Tables getTableByPathParamValue(String pathParamValue) {
        return Arrays.
                stream(Tables.values()).
                filter(x -> x.getPathParamValue().equals(pathParamValue)).
                findFirst().
                orElseThrow();
    }
}
