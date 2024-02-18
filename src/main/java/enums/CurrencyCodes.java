package enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum CurrencyCodes {
    USD("dolar amerykański", "USD");

    private final String currencyName;
    private final String currencyCode;


    CurrencyCodes(String currencyName, String currencyCode) {
        this.currencyName = currencyName;
        this.currencyCode = currencyCode;
    }

    public static CurrencyCodes getCurrencyEnumByCurrencyCode(String currencyCode){
        return Arrays.
                stream(CurrencyCodes.values()).
                filter(x-> x.getCurrencyCode().equals(currencyCode)).
                findFirst().
                orElseThrow();
    }
    public static CurrencyCodes getCurrencyEnumByCurrencyName(String currencyName){
        return Arrays.
                stream(CurrencyCodes.values()).
                filter(x-> x.getCurrencyName().equals(currencyName)).
                findFirst().
                orElseThrow();
    }
}
