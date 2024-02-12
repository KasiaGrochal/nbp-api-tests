package enums;

import lombok.Getter;

import java.util.Arrays;

public enum Tables {
    TABLE_A("A"),
    TABLE_B("B"),
    TABLE_C("C");

    @Getter
    private String specificTableEndpoint;


    Tables(String specificTableEndpoint) {
        this.specificTableEndpoint = specificTableEndpoint;
    }

    public static Tables getTableByTableType(String tableType){
        return Arrays.stream(Tables.values()).filter(x-> x.getSpecificTableEndpoint().equals(tableType)).findFirst().orElseThrow();
    }
}
